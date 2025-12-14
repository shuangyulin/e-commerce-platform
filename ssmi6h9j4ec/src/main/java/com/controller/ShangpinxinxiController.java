package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;
import com.entity.OrdersEntity;
import com.service.OrdersService;
import com.utils.UserBasedCollaborativeFiltering;

import com.entity.ShangpinxinxiEntity;
import com.entity.view.ShangpinxinxiView;

import com.service.ShangpinxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 商品信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-20 11:58:57
 */
@RestController
@RequestMapping("/shangpinxinxi")
public class ShangpinxinxiController {
    @Autowired
    private ShangpinxinxiService shangpinxinxiService;


    @Autowired
    private StoreupService storeupService;

    @Autowired
    private OrdersService ordersService;






    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShangpinxinxiEntity shangpinxinxi,
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			shangpinxinxi.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ShangpinxinxiEntity> ew = new EntityWrapper<ShangpinxinxiEntity>();
        if(pricestart!=null) ew.ge("price", pricestart);
        if(priceend!=null) ew.le("price", priceend);


        //查询结果
		PageUtils page = shangpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }

    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShangpinxinxiEntity shangpinxinxi,
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShangpinxinxiEntity> ew = new EntityWrapper<ShangpinxinxiEntity>();
        if(pricestart!=null) ew.ge("price", pricestart);
        if(priceend!=null) ew.le("price", priceend);

        //查询结果
		PageUtils page = shangpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }


	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShangpinxinxiEntity shangpinxinxi){
       	EntityWrapper<ShangpinxinxiEntity> ew = new EntityWrapper<ShangpinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shangpinxinxi, "shangpinxinxi"));
        return R.ok().put("data", shangpinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShangpinxinxiEntity shangpinxinxi){
        EntityWrapper< ShangpinxinxiEntity> ew = new EntityWrapper< ShangpinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shangpinxinxi, "shangpinxinxi"));
		ShangpinxinxiView shangpinxinxiView =  shangpinxinxiService.selectView(ew);
		return R.ok("查询商品信息成功").put("data", shangpinxinxiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShangpinxinxiEntity shangpinxinxi = shangpinxinxiService.selectById(id);
        if(null==shangpinxinxi.getClicknum()){
            shangpinxinxi.setClicknum(0);
        }
		shangpinxinxi.setClicknum(shangpinxinxi.getClicknum()+1);
		shangpinxinxiService.updateById(shangpinxinxi);
        shangpinxinxi = shangpinxinxiService.selectView(new EntityWrapper<ShangpinxinxiEntity>().eq("id", id));
				Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shangpinxinxi,deSens);
        return R.ok().put("data", shangpinxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShangpinxinxiEntity shangpinxinxi = shangpinxinxiService.selectById(id);
        if(null==shangpinxinxi.getClicknum()){
            shangpinxinxi.setClicknum(0);
        }
		shangpinxinxi.setClicknum(shangpinxinxi.getClicknum()+1);
		shangpinxinxiService.updateById(shangpinxinxi);
        shangpinxinxi = shangpinxinxiService.selectView(new EntityWrapper<ShangpinxinxiEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shangpinxinxi,deSens);
        return R.ok().put("data", shangpinxinxi);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShangpinxinxiEntity shangpinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangpinxinxi);

        shangpinxinxiService.insert(shangpinxinxi);
        return R.ok().put("data",shangpinxinxi.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShangpinxinxiEntity shangpinxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shangpinxinxi);

        shangpinxinxiService.insert(shangpinxinxi);
        return R.ok().put("data",shangpinxinxi.getId());
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShangpinxinxiEntity shangpinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangpinxinxi);
        //全部更新
        shangpinxinxiService.updateById(shangpinxinxi);
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shangpinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
    Wrapper<ShangpinxinxiEntity> wrapper = new EntityWrapper<ShangpinxinxiEntity>();

    // 从map中获取remindStart和remindEnd，组装提醒过滤条件
    Object remindStart = map.get("remindstart") != null ? map.get("remindstart").toString() : null;
    Object remindEnd = map.get("remindend") != null ? map.get("remindend").toString() : null;
    if ("2".equals(type)) {
        Date startDate = null;
        Date endDate = null;
        if (null != remindStart) {
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DAY_OF_MONTH, Integer.parseInt(remindStart.toString()));
            startDate = c.getTime();
        }
        if (null != remindEnd) {
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DAY_OF_MONTH, Integer.parseInt(remindEnd.toString()));
            endDate = c.getTime();
        }
        if (startDate != null && endDate != null) {
            if (startDate.before(endDate)) {
                wrapper.ge(columnName, startDate).le(columnName, endDate);
            } else {
                wrapper.ge(columnName, startDate).or().le(columnName, endDate);
            }
        } else if (startDate == null && endDate != null) {
            wrapper.le(columnName, endDate);
        } else if (startDate != null && endDate == null) {
            wrapper.ge(columnName, startDate);
        }
    } else {
        if (remindStart != null && remindEnd != null) {
            if (Double.parseDouble(remindStart.toString()) < Double.parseDouble(remindEnd.toString())) {
                wrapper.ge(columnName, remindStart).le(columnName, remindEnd);
            } else {
                wrapper.ge(columnName, remindStart).or().le(columnName, remindEnd);
            }
        } else if (remindStart == null && remindEnd != null) {
            wrapper.le(columnName, remindEnd);
        } else if (remindStart != null && remindEnd == null) {
            wrapper.ge(columnName, remindStart);
        }
    }

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			wrapper.andNew().eq("shangjiazhanghao", (String)request.getSession().getAttribute("username"));
		}
        //根据条件，查询结果
        List<ShangpinxinxiEntity> list = shangpinxinxiService.selectList(wrapper);
        Map<String,Object> res= new HashMap<>();
        res.put("count", list.size());
        res.put("data",list.stream().map(ShangpinxinxiEntity::getShangpinmingcheng).collect(Collectors.toList()));
        return R.ok(res);
	}
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ShangpinxinxiEntity shangpinxinxi, HttpServletRequest request,String pre){
        EntityWrapper<ShangpinxinxiEntity> ew = new EntityWrapper<ShangpinxinxiEntity>();
        ew.eq("onshelves","1");
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");

        params.put("order", "desc");
		PageUtils page = shangpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinxinxi), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（基于用户的协同算法）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,ShangpinxinxiEntity shangpinxinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        // 查询订单数据
        List<OrdersEntity> orders = ordersService.selectList(new EntityWrapper<OrdersEntity>());
        Map<String, Map<String, Double>> ratings = new HashMap<>();
        if(orders!=null && orders.size()>0) {
            for(OrdersEntity o : orders) {
                Map<String, Double> userRatings = null;
                if(ratings.containsKey(o.getUserid().toString())) {
                    userRatings = ratings.get(o.getUserid().toString());
                } else {
                    userRatings = new HashMap<>();
                    ratings.put(o.getUserid().toString(), userRatings);
                }
                if(userRatings.containsKey(o.getGoodid().toString())) {
                    userRatings.put(o.getGoodid().toString(), userRatings.get(o.getGoodid().toString())+1.0);
                } else {
                    userRatings.put(o.getGoodid().toString(), 1.0);
                }

            }
        }
        // 创建协同过滤对象
        UserBasedCollaborativeFiltering filter = new UserBasedCollaborativeFiltering(ratings);

        // 为指定用户推荐物品
        String targetUser = userId;
        int numRecommendations = limit;
        List<String> recommendations = filter.recommendItems(targetUser, numRecommendations);

        // 输出推荐结果
        System.out.println("Recommendations for " + targetUser + ":");
        for (String item : recommendations) {
            System.out.println(item);
        }

        EntityWrapper<ShangpinxinxiEntity> ew = new EntityWrapper<ShangpinxinxiEntity>();
        ew.eq("onshelves","1");
        ew.in("id", recommendations);
        if(recommendations!=null && recommendations.size()>0 && recommendations.size()>0) {
            ew.last("order by FIELD(id, "+String.join(",", recommendations)+")");
        }

        // 根据协同结果查询结果并返回
        PageUtils page = shangpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangpinxinxi), params), params));
        List<ShangpinxinxiEntity> pageList = (List<ShangpinxinxiEntity>)page.getList();
        if(recommendations!=null && recommendations.size()>0 && pageList.size()<limit) {
            int toAddNum = limit-pageList.size();
            ew = new EntityWrapper<ShangpinxinxiEntity>();
            ew.notIn("id", recommendations);
            ew.orderBy("id", false);
            ew.last("limit "+toAddNum);
            pageList.addAll(shangpinxinxiService.selectList(ew));
        } else if(pageList.size()>limit) {
            pageList = pageList.subList(0, limit);
        }
        page.setList(pageList);

        return R.ok().put("data", page);
    }







}

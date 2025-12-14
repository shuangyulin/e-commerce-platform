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

import com.entity.DiscussshangpinxinxiEntity;
import com.entity.view.DiscussshangpinxinxiView;

import com.service.DiscussshangpinxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;

/**
 * 商品信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-20 11:58:58
 */
@RestController
@RequestMapping("/discussshangpinxinxi")
public class DiscussshangpinxinxiController {
    @Autowired
    private DiscussshangpinxinxiService discussshangpinxinxiService;









    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussshangpinxinxiEntity discussshangpinxinxi,
		HttpServletRequest request){

        //设置查询条件
        EntityWrapper<DiscussshangpinxinxiEntity> ew = new EntityWrapper<DiscussshangpinxinxiEntity>();


        //查询结果
		PageUtils page = discussshangpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshangpinxinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,DiscussshangpinxinxiEntity discussshangpinxinxi,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscussshangpinxinxiEntity> ew = new EntityWrapper<DiscussshangpinxinxiEntity>();

        //查询结果
		PageUtils page = discussshangpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshangpinxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }


	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussshangpinxinxiEntity discussshangpinxinxi){
       	EntityWrapper<DiscussshangpinxinxiEntity> ew = new EntityWrapper<DiscussshangpinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussshangpinxinxi, "discussshangpinxinxi"));
        return R.ok().put("data", discussshangpinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussshangpinxinxiEntity discussshangpinxinxi){
        EntityWrapper< DiscussshangpinxinxiEntity> ew = new EntityWrapper< DiscussshangpinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussshangpinxinxi, "discussshangpinxinxi"));
		DiscussshangpinxinxiView discussshangpinxinxiView =  discussshangpinxinxiService.selectView(ew);
		return R.ok("查询商品信息评论表成功").put("data", discussshangpinxinxiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussshangpinxinxiEntity discussshangpinxinxi = discussshangpinxinxiService.selectById(id);
        discussshangpinxinxi = discussshangpinxinxiService.selectView(new EntityWrapper<DiscussshangpinxinxiEntity>().eq("id", id));
				Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussshangpinxinxi,deSens);
        return R.ok().put("data", discussshangpinxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussshangpinxinxiEntity discussshangpinxinxi = discussshangpinxinxiService.selectById(id);
        discussshangpinxinxi = discussshangpinxinxiService.selectView(new EntityWrapper<DiscussshangpinxinxiEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussshangpinxinxi,deSens);
        return R.ok().put("data", discussshangpinxinxi);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussshangpinxinxiEntity discussshangpinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussshangpinxinxi);

        discussshangpinxinxiService.insert(discussshangpinxinxi);
        return R.ok().put("data",discussshangpinxinxi.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussshangpinxinxiEntity discussshangpinxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussshangpinxinxi);

        discussshangpinxinxiService.insert(discussshangpinxinxi);
        return R.ok().put("data",discussshangpinxinxi.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussshangpinxinxiEntity discussshangpinxinxi = discussshangpinxinxiService.selectOne(new EntityWrapper<DiscussshangpinxinxiEntity>().eq("", username));
        return R.ok().put("data", discussshangpinxinxi);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussshangpinxinxiEntity discussshangpinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussshangpinxinxi);
        //全部更新
        discussshangpinxinxiService.updateById(discussshangpinxinxi);
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussshangpinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussshangpinxinxiEntity discussshangpinxinxi, HttpServletRequest request,String pre){
        EntityWrapper<DiscussshangpinxinxiEntity> ew = new EntityWrapper<DiscussshangpinxinxiEntity>();
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
		params.put("sort", "clicktime");

        params.put("order", "desc");
		PageUtils page = discussshangpinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshangpinxinxi), params), params));
        return R.ok().put("data", page);
    }









}

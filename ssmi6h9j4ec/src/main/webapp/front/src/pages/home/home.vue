<template>
	<div class="home-preview">

		<!-- 搜索 -->
		<div id="search" class="search animate__animated">
			<div class="select">
				<el-select v-model="queryIndex">
					<el-option
						v-for="(item,index) in queryList"
						:key="index"
						:label="item.queryName"
						:value="index"
					></el-option>
				</el-select>
			</div>
			<div class="input" v-if="queryIndex==0">
				<el-input v-model="shangpinxinxishangpinmingcheng" placeholder="商品名称"></el-input>
			</div>
			<div class="btn" v-if="queryIndex==0">
				<el-button class="search_btn" type="primary" @click="search('shangpinxinxi')">
					<span class="icon iconfont "></span>
					搜索
				</el-button>
			</div>
		</div>
		<!-- 搜索 -->


		<!-- 关于我们 -->
		<div id="about" class="animate__animated">
			<div class="about_item">
				<div class="about_title_box">
					<div class="about_title">{{aboutUsDetail.title}}</div>
					<div class="about_subtitle">{{aboutUsDetail.subtitle}}</div>
				</div>
				<div class="about_img">
					<img :src="baseUrl + aboutUsDetail.picture1">
					<img :src="baseUrl + aboutUsDetail.picture2">
					<img :src="baseUrl + aboutUsDetail.picture3">
				</div>
				<div class="about_content ql-snow ql-editor" v-html="aboutUsDetail.content"></div>
				<div class="about_idea1" />
				<div class="about_idea2" />
				<div class="about_idea3" />
				<div class="about_idea4" />
				<div class="about_more" @click="toDetail('aboutusDetail',aboutUsDetail)">
					<span>查看更多</span>
					<span class="icon iconfont icon-jiantou25"></span>
				</div>
			</div>
		</div>
		<!-- 关于我们 -->

		<!-- 系统简介 -->
		<div id="system" class="animate__animated">
			<div class="system_item">
				<div class="system_title_box">
					<div class="system_title">{{systemIntroductionDetail.title}}</div>
					<div class="system_subtitle">{{systemIntroductionDetail.subtitle}}</div>
				</div>
				<div class="system_img">
					<img :src="baseUrl + systemIntroductionDetail.picture1">
					<img :src="baseUrl + systemIntroductionDetail.picture2">
					<img :src="baseUrl + systemIntroductionDetail.picture3">
				</div>
				<div class="system_content ql-snow ql-editor" v-html="systemIntroductionDetail.content"></div>
				<div class="system_idea1" />
				<div class="system_idea2" />
				<div class="system_idea3" />
				<div class="system_idea4" />
				<div class="system_more" @click="toDetail('systemintroDetail',systemIntroductionDetail)">
					<span>查看更多</span>
					<span class="icon iconfont icon-gengduo1"></span>
				</div>
			</div>
		</div>
		<!-- 系统简介 -->
		<!-- 新闻资讯 -->
		<div id="animate_newsnews" class="news animate__animated">
			<div class="news_title_box">
				<span class="news_title">公告信息</span>
				<span class="news_subhead">{{'news'.toUpperCase()}}</span>
			</div>
			<!-- 样式五 -->
			<div v-if="newsList.length" class="list list5 index-pv1">
				<div @click="toDetail('newsDetail', newsList[0])" v-if="newsList.length>0" class="list-item animation-box">
					<img :src="baseUrl + newsList[0].picture" alt="">
					<div class="infoBox">
						<div class="name line1">{{newsList[0].title}}</div>
						<div class="desc line3">{{newsList[0].introduction}}</div>
						<div class="time_item">
							<span class="icon iconfont icon-shijian21"></span>
							<span class="label">发布时间：</span>
							<span class="text">{{newsList[0].addtime.split(' ')[0]}}</span>
						</div>
						<div class="publisher_item">
							<span class="icon iconfont icon-geren16"></span>
							<span class="label">发布人：</span>
							<span class="text">{{newsList[0].name}}</span>
						</div>
						<div class="like_item">
							<span class="icon iconfont icon-zan10"></span>
							<span class="label">点赞：</span>
							<span class="text">{{newsList[0].thumbsupnum}}</span>
						</div>
						<div class="collect_item">
							<span class="icon iconfont icon-shoucang10"></span>
							<span class="label">收藏：</span>
							<span class="text">{{newsList[0].storeupnum}}</span>
						</div>
						<div class="view_item">
							<span class="icon iconfont icon-chakan2"></span>
							<span class="label">点击量：</span>
							<span class="text">{{newsList[0].clicknum}}</span>
						</div>
					</div>
				</div>
				<div class="list-body">
					<div @click="toDetail('newsDetail', newsList[1])" v-if="newsList.length>1" class="list-item1 animation-box">
						<div class="name line1">{{newsList[1].title}}</div>
						<div class="desc line3">{{newsList[1].introduction}}</div>
						<div class="time_item">
							<span class="icon iconfont icon-shijian21"></span>
							<span class="label">发布时间：</span>
							<span class="text">{{newsList[1].addtime.split(' ')[0]}}</span>
						</div>
						<div class="publisher_item">
							<span class="icon iconfont icon-geren16"></span>
							<span class="label">发布人：</span>
							<span class="text">{{newsList[1].name}}</span>
						</div>
						<div class="like_item">
							<span class="icon iconfont icon-zan10"></span>
							<span class="label">点赞：</span>
							<span class="text">{{newsList[1].thumbsupnum}}</span>
						</div>
						<div class="collect_item">
							<span class="icon iconfont icon-shoucang10"></span>
							<span class="label">收藏：</span>
							<span class="text">{{newsList[1].storeupnum}}</span>
						</div>
						<div class="view_item">
							<span class="icon iconfont icon-chakan2"></span>
							<span class="label">浏览次数：</span>
							<span class="text">{{newsList[1].clicknum}}</span>
						</div>
					</div>
					<div @click="toDetail('newsDetail', newsList[2])" v-if="newsList.length>2" class="list-item2 animation-box">
						<div class="name line1">{{newsList[2].title}}</div>
						<div class="desc line3">{{newsList[2].introduction}}</div>
						<div class="time_item">
							<span class="icon iconfont icon-shijian21"></span>
							<span class="label">发布时间：</span>
							<span class="text">{{newsList[2].addtime.split(' ')[0]}}</span>
						</div>
						<div class="publisher_item">
							<span class="icon iconfont icon-geren16"></span>
							<span class="label">发布人：</span>
							<span class="text">{{newsList[2].name}}</span>
						</div>
						<div class="like_item">
							<span class="icon iconfont icon-zan10"></span>
							<span class="label">点赞：</span>
							<span class="text">{{newsList[2].thumbsupnum}}</span>
						</div>
						<div class="collect_item">
							<span class="icon iconfont icon-shoucang10"></span>
							<span class="label">收藏：</span>
							<span class="text">{{newsList[2].storeupnum}}</span>
						</div>
						<div class="view_item">
							<span class="icon iconfont icon-chakan2"></span>
							<span class="label">浏览次数：</span>
							<span class="text">{{newsList[2].clicknum}}</span>
						</div>
					</div>
					<div @click="toDetail('newsDetail', newsList[3])" v-if="newsList.length>3" class="list-item3 animation-box">
						<div class="name line1">{{newsList[3].title}}</div>
						<div class="desc line3">{{newsList[3].introduction}}</div>
						<div class="time_item">
							<span class="icon iconfont icon-shijian21"></span>
							<span class="label">发布时间：</span>
							<span class="text">{{newsList[3].addtime.split(' ')[0]}}</span>
						</div>
						<div class="publisher_item">
							<span class="icon iconfont icon-geren16"></span>
							<span class="label">发布人：</span>
							<span class="text">{{newsList[3].name}}</span>
						</div>
						<div class="like_item">
							<span class="icon iconfont icon-zan10"></span>
							<span class="label">点赞：</span>
							<span class="text">{{newsList[3].thumbsupnum}}</span>
						</div>
						<div class="collect_item">
							<span class="icon iconfont icon-shoucang10"></span>
							<span class="label">收藏：</span>
							<span class="text">{{newsList[3].storeupnum}}</span>
						</div>
						<div class="view_item">
							<span class="icon iconfont icon-chakan2"></span>
							<span class="label">浏览次数：</span>
							<span class="text">{{newsList[3].clicknum}}</span>
						</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('news')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 新闻资讯 -->
		<!-- 商品推荐 -->
		<div id="animate_recommendshangpinxinxi" class="recommend animate__animated">
			<div class="recommend_title_box">
				<span class="recommend_title">商品信息推荐</span>
				<span class="recommend_subhead">{{'shangpinxinxi'.toUpperCase()}} RECOMMEND</span>
			</div>
			<div class="list list21 index-pv1">
				<div class="list-body-top">
					<div class="tab-title">商品信息推荐</div>
					<div class="tab-right" @click="moreBtn('shangpinxinxi')">
						<span class="text">查看更多</span>
						<span class="icon iconfont icon-gengduo1"></span>
					</div>
				</div>
				<div class="list-body">
					<div v-if="index<Number(4)" class="list-item" v-for="(item,index) in shangpinxinxiRecommend" :key="index" @click="toDetail('shangpinxinxiDetail', item)">
						<div class="img">
							<img v-if="preHttp(item.shangpintupian)" :src="item.shangpintupian.split(',')[0]" alt="" />
							<img v-else :src="baseUrl + (item.shangpintupian?item.shangpintupian.split(',')[0]:'')" alt="" />
						</div>
						<div class="infoBox">
							<div class="name">{{item.shangpinmingcheng}}</div>
							<div class="name">{{item.shangpinfenlei}}</div>
							<div class="name">{{item.alllimittimes}}</div>
							<div class="bottomInfo">
								<div class="price">￥{{item.price}}</div>
								<div class="time_item">
									<span class="icon iconfont icon-shijian21"></span>
									<span class="label">发布时间：</span>
									<span class="text">{{item.addtime.split(' ')[0]}}</span>
								</div>
								<div class="publisher_item">
									<span class="icon iconfont icon-touxiang18"></span>
									<span class="label">发布人：</span>
									<span class="text">{{item.shangjiazhanghao}}</span>
								</div>
								<div class="collect_item">
									<span class="icon iconfont icon-shoucang10"></span>
									<span class="label">收藏：</span>
									<span class="text">{{item.storeupnum}}</span>
								</div>
								<div class="view_item">
									<span class="icon iconfont icon-liulan04"></span>
									<span class="label">浏览次数：</span>
									<span class="text">{{item.clicknum}}</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('shangpinxinxi')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 商品推荐 -->
	</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

	export default {
		//数据集合
		data() {
			return {
				baseUrl: '',
				aboutUsDetail: {},
				systemIntroductionDetail: {},
				queryList:[
					{
						queryName:"商品名称",
					},
				],
				queryIndex: 0,
				shangpinxinxishangpinmingcheng: '',
				newsList: [],
				shangpinxinxiRecommend: [],



				recommendIndex21shangpinxinxi: 0,
				recommendList21shangpinxinxi: [],
				recommendColumn21shangpinxinxi: '',


			}
		},
		created() {
			this.baseUrl = this.$config.baseUrl;
			this.getNewsList();
			this.getAboutUs();
			this.getSystemIntroduction();
			this.getList();
			this.shangpinxinxiRecommendCate()
		},
		mounted() {
			window.addEventListener('scroll', this.handleScroll)
			setTimeout(()=>{
				this.handleScroll()
			},100)
			
			this.swiperChanges()
		},
		beforeDestroy() {
			window.removeEventListener('scroll', this.handleScroll)
		},
		//方法集合
		methods: {
			swiperChanges() {
				setTimeout(()=>{
				},750)
			},
			shangpinxinxiRecommendCate(){
				this.$http.get('shangpinfenlei/list',{
					params: {
						limit: Number(6)
					}
				}).then(res => {
					if (res.data.code == 0) {
						this.recommendList21shangpinxinxi = res.data.data.list
					}
				});
				this.recommendColumn21shangpinxinxi = 'shangpinfenlei'
			},
			async recommendIndexClick21(index, name) {
				this['recommendIndex21' + name] = index
				await this.getList()
			},


			handleScroll() {
				let arr = [
					{id:'search',css:'animate__'},
					{id:'about',css:'animate__'},
					{id:'system',css:'animate__'},
					{id:'animate_recommendshangpinxinxi',css:'animate__'},
					{id:'animate_newsnews',css:'animate__'},
				]
			
				for (let i in arr) {
					let doc = document.getElementById(arr[i].id)
					if (doc) {
						let top = doc.offsetTop
						let win_top = window.innerHeight + window.pageYOffset
						// console.log(top,win_top)
						if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
							// console.log(doc)
							doc.classList.add(arr[i].css)
						}
					}
				}
			},
			preHttp(str) {
				return str && str.substr(0,4)=='http';
			},
			preHttp2(str) {
				return str && str.split(',w').length>1;
			},
			getAboutUs() {
				this.$http.get('aboutus/detail/1', {}).then(res => {
					if(res.data.code == 0) {
						this.aboutUsDetail = res.data.data;
					}
				})
			},
			getSystemIntroduction() {
				this.$http.get('systemintro/detail/1', {}).then(res => {
					if(res.data.code == 0) {
						this.systemIntroductionDetail = res.data.data;
					}
				})
			},
			search(tablename) {
				if (this.queryIndex == 0 && this.shangpinxinxishangpinmingcheng) {
					this.$router.push({path: '/index/' + tablename, query: {indexQueryCondition: this.shangpinxinxishangpinmingcheng}});
				}
			},
			getNewsList() {
				let data = {
					page: 1,
					limit: 4,
					sort: 'addtime',
					order: 'desc'
				}
				this.$http.get('news/list', {params: data}).then(res => {
					if (res.data.code == 0) {
						this.newsList = res.data.data.list;
					
					}
				});
			},
			getList() {
				let autoSortUrl = "";
				let data = {}
				autoSortUrl = "shangpinxinxi/autoSort";
				if(localStorage.getItem('frontToken')) {
					autoSortUrl = "shangpinxinxi/autoSort2";
				}
				data = {
					page: 1,
					limit: 8,
					onshelves: 1,
				}
				if(this.recommendIndex21shangpinxinxi != 0){
					data.shangpinfenlei = this.recommendList21shangpinxinxi[this.recommendIndex21shangpinxinxi - 1].shangpinfenlei
				}
				this.$http.get(autoSortUrl, {params: data}).then(res => {
					if (res.data.code == 0) {
						this.shangpinxinxiRecommend = res.data.data.list;
					}
				});
			
			},
			toDetail(path, item) {
				this.$router.push({path: '/index/' + path, query: {id: item.id}});
			},
			moreBtn(path) {
				this.$router.push({path: '/index/' + path});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		margin: 0px auto;
		flex-direction: column;
		background: #fff;
		display: flex;
		width: 100%;
		.search {
			padding: 10px 0;
			margin: 0px auto 20px;
			z-index: 9;
			display: flex;
			border-color: #ddd;
			flex-wrap: wrap;
			border-radius: 0;
			background: none;
			width: 100%;
			justify-content: center;
			border-width: 0 0 1px;
			align-items: center;
			border-style: solid;
			height: auto;
			.select {
				margin: 0;
				.el-select {
					margin: 0 5px 0 0;
					width: auto;
					/deep/ .el-input__inner {
						border: 1px solid #0673fa;
						border-radius: 4px;
						padding: 0 30px 0 10px;
						color: #333;
						background: #fff;
						width: 180px;
						font-size: 16px;
						height: 36px;
					}
				}
			}
			.input {
				padding: 0;
				margin: 0 5px 0 0;
				.el-input {
					width: 100%;
					/deep/ .el-input__inner {
						border: 1px solid #0673fa;
						border-radius: 4px;
						padding: 0 10px;
						color: #333;
						background: #fff;
						width: 180px;
						font-size: 16px;
						height: 36px;
					}
				}
			}
			.btn {
				padding: 0;
				margin: 0;
				.search_btn {
					border: 0;
					cursor: pointer;
					border-radius: 4px;
					padding: 0 20px;
					margin: 0;
					color: rgba(255, 255, 255, 1);
					background: #0673fa;
					width: auto;
					font-size: 16px;
					line-height: 36px;
					height: 36px;
					.icon {
						margin: 0 4px 0 0;
						color: rgba(255, 255, 255, 1);
						font-size: 16px;
					}
				}
				.search_btn:hover {
					opacity: 1;
				}
			}
		}
		#about {
			padding: 150px 0 0;
			margin: 0 auto;
			background: url(http://codegen.caihongy.cn/20241228/9546ef46cbbf4e1ca818c4892bc70b8c.jpg) no-repeat center top / 100% 100%;
			width: 100%;
			position: relative;
			height: auto;
			order: 3;
			.about_item {
				padding: 0;
				margin: 0 0 0 calc((100% - 1200px)/2);
				z-index: 9;
				overflow: hidden;
				align-content: flex-start;
				background: none;
				display: flex;
				width: 1000px;
				flex-wrap: wrap;
				height: 640px;
				.about_title_box {
					padding: 0;
					margin: 0;
					background: url(http://codegen.caihongy.cn/20241228/7c333d0bae514723af73e0ceb9c92605.png) no-repeat left bottom / 100% auto;
					width: 100%;
					text-align: left;
					.about_title {
						margin: 0 auto;
						color: #000;
						background: none;
						font-weight: 600;
						display: inline-block;
						width: auto;
						font-size: 32px;
						line-height: 110px;
						text-align: left;
					}
					.about_subtitle {
						margin: 0;
						color: #999;
						display: none;
						width: 100%;
						font-size: 18px;
						line-height: 40px;
						text-align: center;
					}
				}
				.about_img {
					padding: 0;
					margin: 0;
					z-index: 999;
					top: 0;
					background: none;
					display: flex;
					width: calc((100% - 1200px)/2 + 150px);
					position: absolute;
					right: 0;
					flex-wrap: wrap;
					height: 100%;
					order: 2;
					img:nth-child(1) {
						margin: 0;
						clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 32%);
						object-fit: cover;
						display: block;
						width: 100%;
						height: 100%;
					}
					img:nth-child(2) {
						margin: 0;
						object-fit: cover;
						display: none;
						width: 34%;
						height: 100%;
					}
					img:nth-child(3) {
						margin: 0;
						object-fit: cover;
						display: none;
						width: 33%;
						height: 100%;
					}
				}
				.about_content {
					padding: 0;
					margin: 50px 0 0;
					overflow: hidden;
					color: #333;
					background: none;
					width: 100%;
					font-size: 16px;
					line-height: 30px;
					height: 210px;
				}
				.about_idea1 {
					z-index: -1;
					top: 0;
					background: #d10602;
					display: none;
					width: 50%;
					position: absolute;
					right: 0;
					height: 400px;
				}
				.about_idea2 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.about_idea3 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.about_idea4 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.about_more {
					border: 0px solid #999;
					border-radius: 10px;
					padding: 0 20px;
					margin: 40px 0 0;
					background: #3397da;
					display: block;
					width: 230px;
					line-height: 50px;
					text-align: center;
					order: 3;
					span:nth-child(1) {
						color: #fff;
						font-size: 18px;
					}
					span:nth-child(2) {
						color: #fff;
						display: none;
						font-size: 18px;
					}
				}
				.about_more:hover {
					cursor: pointer;
					opacity: 1;
				}
			}
		}
		#system {
			padding: 0;
			margin: 0;
			background: url(http://codegen.caihongy.cn/20250103/85c08454fdb743eb8c321e8f8db49d0c.jpg) no-repeat left bottom,#e8f2fb;
			width: 100%;
			position: relative;
			height: 800px;
			order: 8;
			.system_item {
				margin: 0 auto;
				display: block;
				width: 1200px;
				flex-wrap: wrap;
				.system_title_box {
					padding: 0 0 20px;
					margin: 80px 0 0;
					z-index: 999;
					left: calc((100% - 1200px)/2 + 200px);
					background: url(http://codegen.caihongy.cn/20250103/9fafb6981cb04273a7cd4f1473fbbed4.png) no-repeat left bottom;
					width: 1000px;
					position: absolute;
					text-align: left;
					.system_title {
						margin: 0;
						color: #000;
						background: none;
						font-weight: 500;
						width: 100%;
						font-size: 26px;
						line-height: 40px;
						text-align: left;
					}
					.system_subtitle {
						margin: 0;
						color: #999;
						display: none;
						width: 100%;
						font-size: 18px;
						line-height: 40px;
						text-align: center;
					}
				}
				.system_img {
					padding: 0;
					margin: 0;
					z-index: 999;
					top: 0;
					left: 0;
					background: none;
					display: flex;
					width: calc((100% - 1200px)/2 + 120px);
					position: absolute;
					flex-wrap: wrap;
					height: 92%;
					order: 2;
					img:nth-child(1) {
						margin: 0;
						clip-path: polygon(100% 0, 100% 100%, 0 40%, 0 0);
						object-fit: cover;
						display: block;
						width: 100%;
						height: 100%;
					}
					img:nth-child(2) {
						border-radius: 50px;
						margin: 0;
						left: calc((100% - 1400px)/2);
						bottom: 40px;
						object-fit: cover;
						display: none;
						width: 20%;
						position: absolute;
						height: 380px;
					}
					img:nth-child(3) {
						border-radius: 50px;
						margin: 0;
						left: calc((100% - 1400px)/2 + 20% + 40px);
						bottom: 40px;
						object-fit: cover;
						display: none;
						width: 20%;
						position: absolute;
						height: 380px;
					}
				}
				.system_content {
					padding: 0;
					margin: 200px 0 0;
					z-index: 99;
					overflow: hidden;
					color: #000;
					background: none;
					width: 1000px;
					font-size: 16px;
					line-height: 30px;
					float: right;
					height: 300px;
				}
				.system_idea1 {
					padding: 0;
					margin: 0;
					z-index: 0;
					overflow: hidden;
					color: #666;
					background: #fff;
					display: none;
					width: 400px;
					font-size: 16px;
					line-height: 30px;
					height: 480px;
				}
				.system_idea2 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.system_idea3 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.system_idea4 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.system_more {
					border: 0px solid #999;
					margin: 0;
					z-index: 999;
					bottom: 230px;
					display: block;
					line-height: 50px;
					float: right;
					border-radius: 10px;
					left: calc((100% - 1200px)/2 + 200px);
					background: #3397da;
					width: 250px;
					position: absolute;
					text-align: center;
					span:nth-child(1) {
						color: #fff;
						font-size: 16px;
					}
					span:nth-child(2) {
						color: #fff;
						display: none;
						font-size: 16px;
					}
				}
				.system_more:hover {
					cursor: pointer;
					opacity: 1;
				}
			}
		}
		.news {
			padding: 0;
			margin: 0;
			background: url(http://codegen.caihongy.cn/20250103/5efd25a6df7c4bed92416b2d2de8f137.jpg) no-repeat center top / 100% 100%;
			width: 100%;
			position: relative;
			text-align: center;
			order: 11;
			.news_title_box {
				padding: 0;
				margin: 0;
				background: url(http://codegen.caihongy.cn/20241228/f151b89f53c94b7fa5ae510c2f7bd563.png) no-repeat center bottom;
				width: 100%;
				position: relative;
				text-align: center;
				height: 191px;
				.news_title {
					margin: 0 auto;
					color: #fff;
					background: none;
					font-weight: 600;
					display: block;
					letter-spacing: 1px;
					width: auto;
					font-size: 32px;
					line-height: 100px;
					text-align: center;
				}
				.news_subhead {
					margin: 0;
					color: #999;
					display: none;
					width: 100%;
					font-size: 18px;
					line-height: 40px;
					text-align: center;
				}
			}
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list5 {
				padding: 0;
				margin: 20px auto;
				color: #888;
				background: none;
				width: 1200px;
				font-size: 14px;
				text-align: left;
				height: auto;
				.list-item {
					cursor: pointer;
					border: 4px solid #dfb858;
					padding: 20px;
					margin: 0 0 25px;
					background: #fff;
					width: 100%;
					height: auto;
					img {
						object-fit: cover;
						width: 275px;
						float: left;
						height: 275px;
					}
					.infoBox {
						padding: 10px;
						align-content: center;
						background: none;
						display: inline-flex;
						width: calc(100% - 275px);
						align-items: center;
						flex-wrap: wrap;
						height: 275px;
						.name {
							padding: 10px;
							overflow: hidden;
							color: #333;
							white-space: nowrap;
							font-weight: 600;
							width: 100%;
							font-size: 16px;
							line-height: 1.5;
							text-overflow: ellipsis;
						}
						.desc {
							padding: 10px;
							max-height: 150px;
							overflow: hidden;
							color: #666;
							width: 100%;
							font-size: 14px;
							line-height: 30px;
							height: auto;
						}
						.time_item {
							padding: 0 10px;
							margin: 5px 0;
							color: #555;
							display: inline-block;
							width: 100%;
							order: 11;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.publisher_item {
							padding: 0 10px;
							color: #214ea1;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.like_item {
							padding: 0 10px;
							color: #ea8021;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.collect_item {
							padding: 0 10px;
							color: #179da9;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								color: #666;
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.view_item {
							padding: 0 10px;
							color: #f00;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								color: #666;
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
					}
				}
				.list-body {
					background: none;
					display: flex;
					width: 100%;
					justify-content: space-between;
					flex-wrap: wrap;
					height: 275px;
					.list-item1 {
						cursor: pointer;
						border: 4px solid #3397da;
						padding: 20px 10px 10px 20px;
						align-content: center;
						background: #fff;
						display: flex;
						width: 32%;
						align-items: center;
						position: relative;
						flex-wrap: wrap;
						height: 275px;
						.name {
							padding: 0 10px 0 0;
							overflow: hidden;
							color: #333;
							white-space: nowrap;
							font-weight: 600;
							width: 100%;
							font-size: 16px;
							line-height: 1.5;
							text-overflow: ellipsis;
						}
						.desc {
							padding: 10px 10px 10px 0;
							overflow: hidden;
							color: #666;
							width: 100%;
							font-size: 14px;
							line-height: 28px;
							height: 150px;
						}
						.time_item {
							padding: 0 0px;
							margin: 5px 0;
							color: #555;
							display: inline-block;
							width: 100%;
							order: 11;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.publisher_item {
							padding: 0 10px 0 0;
							color: #214ea1;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.like_item {
							padding: 0 10px 0 0;
							color: #ea8021;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.collect_item {
							padding: 0 10px 0 0;
							color: #179da9;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.view_item {
							padding: 0 10px 0 0;
							color: #f00;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
					}
					.list-item2 {
						cursor: pointer;
						border: 4px solid #3397da;
						padding: 20px 10px 10px 20px;
						align-content: center;
						background: #fff;
						display: flex;
						width: 32%;
						align-items: center;
						position: relative;
						flex-wrap: wrap;
						height: 275px;
						.name {
							padding: 0 10px 0 0;
							overflow: hidden;
							color: #333;
							white-space: nowrap;
							font-weight: 600;
							width: 100%;
							font-size: 16px;
							line-height: 1.5;
							text-overflow: ellipsis;
						}
						.desc {
							padding: 10px 10px 10px 0;
							overflow: hidden;
							color: #666;
							width: 100%;
							font-size: 14px;
							line-height: 28px;
							height: 150px;
						}
						.time_item {
							padding: 0 0px;
							margin: 5px 0;
							color: #555;
							display: inline-block;
							width: 100%;
							order: 11;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.publisher_item {
							padding: 0 10px 0 0;
							color: #214ea1;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.like_item {
							padding: 0 10px 0 0;
							color: #ea8021;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.collect_item {
							padding: 0 10px 0 0;
							color: #179da9;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.view_item {
							padding: 0 10px 0 0;
							color: #f00;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
					}
					.list-item3 {
						cursor: pointer;
						border: 4px solid #3397da;
						padding: 20px 10px 10px 20px;
						align-content: center;
						background: #fff;
						display: flex;
						width:  32%;
						align-items: center;
						position: relative;
						flex-wrap: wrap;
						height: 275px;
						.name {
							padding: 0 10px 0 0;
							overflow: hidden;
							color: #333;
							white-space: nowrap;
							font-weight: 600;
							width: 100%;
							font-size: 16px;
							line-height: 1.5;
							text-overflow: ellipsis;
						}
						.desc {
							padding: 10px 10px 10px 0;
							overflow: hidden;
							color: #666;
							width: 100%;
							font-size: 14px;
							line-height: 28px;
							height: 150px;
						}
						.time_item {
							padding: 0 0px;
							margin: 5px 0;
							color: #555;
							display: inline-block;
							width: 100%;
							order: 11;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.publisher_item {
							padding: 0 10px 0 0;
							color: #214ea1;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.like_item {
							padding: 0 10px 0 0;
							color: #ea8021;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.collect_item {
							padding: 0 10px 0 0;
							color: #179da9;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
						.view_item {
							padding: 0 10px 0 0;
							color: #f00;
							display: inline-block;
							.icon {
								margin: 0 2px 0 0;
								line-height: 1.5;
							}
							.label {
								display: none;
								line-height: 1.5;
							}
							.text {
								line-height: 1.5;
							}
						}
					}
				}
			}
			.moreBtn {
				border: 0px solid #999;
				cursor: pointer;
				border-radius: 10px;
				padding: 0 20px;
				margin: 20px auto 40px;
				background: #3397da;
				display: inline-block;
				width: 250px;
				line-height: 48px;
				text-align: center;
				.text {
					color: #fff;
					font-size: 16px;
				}
				.icon {
					color: #333;
					display: none;
					font-size: 15px;
				}
			}
		}
		.recommend {
			padding: 0 0 10px;
			margin: 0px auto;
			background: url(http://codegen.caihongy.cn/20241228/80c792bd909b471aa43fff826e4d14d7.jpg) no-repeat center bottom / 100% auto;
			width: 100%;
			position: relative;
			text-align: center;
			order: 1;
			.recommend_title_box {
				padding: 0;
				margin: 0;
				background: url(http://codegen.caihongy.cn/20241228/f151b89f53c94b7fa5ae510c2f7bd563.png) no-repeat center bottom;
				width: 100%;
				position: relative;
				text-align: center;
				height: 191px;
				.recommend_title {
					margin: 0 auto;
					color: #fff;
					background: none;
					font-weight: 600;
					display: block;
					letter-spacing: 1px;
					width: auto;
					font-size: 32px;
					line-height: 100px;
					text-align: center;
				}
				.recommend_subhead {
					margin: 0;
					color: #999;
					display: none;
					width: 100%;
					font-size: 18px;
					line-height: 40px;
					text-align: center;
				}
			}
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list21 {
				border: 0;
				padding: 0;
				background: none;
				width: 100%;
				text-align: left;
				.list-body-top {
					padding: 60px 20px 180px;
					margin: 0 auto;
					background: url(http://codegen.caihongy.cn/20240809/ce61590e38bc47b0b2b556bdeaa52d38.jpg) no-repeat center bottom / cover;
					display: none;
					width: 100%;
					justify-content: center;
					align-items: center;
					.tab-title {
						margin: 0 40px 0 0;
						color: #fff;
						display: none;
						font-size: 28px;
						line-height: 34px;
						height: 38px;
					}
					.tab_view {
						display: flex;
						.tab {
							cursor: pointer;
							padding: 0 30px;
							margin: 2px 0 0;
							color: #fff;
							font-size: 16px;
							line-height: 34px;
							height: 34px;
						}
						.tab::before {
						}
						.tab:hover {
							color: #000;
							background: #fff;
							position: relative;
						}
						.tab:hover::before {
							border: 1px solid #ddd;
							margin: 0 0 0 -6px;
							left: 50%;
							bottom: -6px;
							display: inline-block;
							border-color: #fff transparent;
							border-width: 6px 6px 0;
							position: absolute;
							content: "";
						}
						.tab.tabActive:hover {
							color: #000;
							background: #fff;
							position: relative;
						}
						.tab.tabActive:hover::before {
							border: 1px solid #fff;
							margin: 0 0 0 -6px;
							left: 50%;
							bottom: -6px;
							display: inline-block;
							border-color: #fff transparent;
							border-width: 6px 6px 0;
							position: absolute;
							content: "";
						}
					}
					.tab-right {
						cursor: pointer;
						display: none;
						line-height: 38px;
						height: 38px;
						.text {
							color: #fff;
							font-size: 16px;
						}
						.icon {
							color: #f5f5f5;
							font-size: 12px;
						}
					}
				}
				.list-body {
					padding: 0;
					margin: 50px auto 0;
					display: flex;
					width: 1200px;
					justify-content: space-between;
					.list-item {
						padding: 0 0 60px;
						margin: 0;
						background: #fff;
						width: 23.5%;
						position: relative;
						.img {
							width: 100%;
							height: 300px;
							img {
								object-fit: cover;
								width: 100%;
								height: 100%;
							}
						}
						.infoBox {
							border: 1px solid #ddd;
							padding: 20px;
							left: 0;
							background: #fff;
							bottom: 0;
							border-width: 0 1px 1px;
							position: absolute;
							right: 0;
							.name {
								margin: 0 0 0px;
								overflow: hidden;
								color: #333;
								white-space: nowrap;
								font-weight: 600;
								display: block;
								width: 100%;
								font-size: 16px;
								line-height: 28px;
								text-overflow: ellipsis;
								text-align: left;
							}
							.bottomInfo {
								overflow: hidden;
								transition: all 0.6s;
								height: 0;
								.price {
									margin: 10px auto 4px;
									color: #f00;
									width: 100%;
									font-size: 18px;
									line-height: 24px;
								}
								.time_item {
									padding: 0;
									.icon {
										margin: 0 2px 0 0;
										color: inherit;
										display: none;
										font-size: inherit;
										line-height: 1.5;
									}
									.label {
										color: inherit;
										font-size: inherit;
										line-height: 1.5;
									}
									.text {
										color: inherit;
										font-size: inherit;
										line-height: 1.5;
									}
								}
								.publisher_item {
									padding: 0;
									.icon {
										margin: 0 2px 0 0;
										color: inherit;
										display: none;
										font-size: inherit;
										line-height: 1.5;
									}
									.label {
										color: inherit;
										font-size: inherit;
										line-height: 1.5;
									}
									.text {
										color: inherit;
										font-size: inherit;
										line-height: 1.5;
									}
								}
								.like_item {
									padding: 0;
									.icon {
										margin: 0 2px 0 0;
										color: inherit;
										display: none;
										font-size: inherit;
										line-height: 1.5;
									}
									.label {
										color: inherit;
										font-size: inherit;
										line-height: 1.5;
									}
									.text {
										color: inherit;
										font-size: inherit;
										line-height: 1.5;
									}
								}
								.collect_item {
									padding: 0;
									.icon {
										margin: 0 2px 0 0;
										color: inherit;
										display: none;
										font-size: inherit;
										line-height: 1.5;
									}
									.label {
										color: inherit;
										font-size: inherit;
										line-height: 1.5;
									}
									.text {
										color: inherit;
										font-size: inherit;
										line-height: 1.5;
									}
								}
								.view_item {
									padding: 0;
									.icon {
										margin: 0 2px 0 0;
										color: inherit;
										display: none;
										font-size: inherit;
										line-height: 1.5;
									}
									.label {
										color: inherit;
										font-size: inherit;
										line-height: 1.5;
									}
									.text {
										color: inherit;
										font-size: inherit;
										line-height: 1.5;
									}
								}
							}
						}
					}
					.list-item::after {
						bottom: 0;
						background: #ffcb2d;
						width: 0;
						position: absolute;
						content: "";
						transition: all 0.6s;
						height: 5px;
					}
					.list-item:hover {
						box-shadow: 0 5px 20px rgba(0, 0, 0, 0.1);
						.infoBox {
							.bottomInfo {
								cursor: pointer;
								height: 200px;
							}
						}
					}
					.list-item:hover::after {
						width: 100%;
					}
				}
			}
			.moreBtn {
				border: 0px solid #999;
				cursor: pointer;
				border-radius: 10px;
				padding: 0 20px;
				margin: 30px auto;
				background: #3397da;
				display: inline-block;
				width: 250px;
				line-height: 48px;
				text-align: center;
				.text {
					color: #fff;
					font-size: 16px;
				}
				.icon {
					color: #fff;
					display: none;
					font-size: 15px;
				}
			}
		}
	}
</style>

export default {
	baseUrl: 'http://localhost:8080/ssmi6h9j4ec/',
	name: '/ssmi6h9j4ec',
	indexNav: [
		{
			name: '商品信息',
			url: '/index/shangpinxinxi',
		},
		{
			name: '交流论坛',
			url: '/index/forum'
		}, 
		{
			name: '公告信息',
			url: '/index/news'
		},
	],
	cateList: [
		{
			name: '商品信息',
			refTable: 'shangpinfenlei',
			refColumn: 'shangpinfenlei',
		},
		{
			name: '交流论坛',
			refTable: 'forumtype',
			refColumn: 'typename',
		},
		{
			name: '公告信息',
			refTable: 'newstype',
			refColumn: 'typename',
		},
	]
}

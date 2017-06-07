$(function(){
	var student = Backbone.Model.extend({
//		url:'save.do',
		defaults:{
			'firstname':'',
			'lastname':''
		}
	});
	
	
	
	var view1=Backbone.View.extend({
		el:'#div2',
		events:{
			'click #b1':'showInfo',
			'click #b2':'hideInfo'
		},
		showInfo:function(){
			var st1 = new student();
			st1.url = 'save.do';
			st1.set({
				'firstname':'aa',
				'lastname':'bb'
			});
//			console.log(st1);
			st1.save(null,{
				success:function(model,response){
					console.log(model);
					console.log(response);
					alert(response);
				}
			});
//			$('#info').show();
		},
		hideInfo:function(){
			var st1 = new student();
			st1.url = 'get.do';
			st1.set({
				'firstname':'aa',
				'lastname':'bb'
			});
//			console.log(st1);
			st1.fetch({data:{'firstname':'FIRSTNAME111'}},{
				success:function(model,response){
					console.log(model);
					console.log(response);
				}
			});
//			$('#info').hide();
		}
	});
	var view11 = new view1();
	
//	var view1={
//			ele:'#div1',
//			tip:'hello world',
//			onClick:function(){
//				$(this.ele).html(this.tip);
//			}
//	}
//	console.log(view1);
//	_.bindAll(view1,'onClick');
//	$(view1.ele).bind('click',view1.onClick);

});

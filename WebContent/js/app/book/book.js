$(function(){
	$('#ss').spinner({
//	    required:true,
//	    increment:10
	});
	$('#btn').bind('click',function(){
		//$('#win').window('open');
		$('#win').window('close');
	});
	$('#cc').combotree('loadData', [{
		id: 1,
		text: 'Languages',
		children: [{
			id: 11,
			text: 'Java'
		},{
			id: 12,
			text: 'C++'
		},{
			id:13,text:'R'
		}]
	}]);
	$('#dg').datagrid({
		url:"book/getbook.do",
		queryParams:{
			'firstname':'a'
		}
	});
	//$('#dg').datagrid('reload');
	$('#addUser').bind('click',newUser);
	$('#editUser').bind('click',editUser);
	$('#delUser').bind('click',delUser);
	$('#saveUser').bind('click',saveUser);
	$('#dlgCancel').bind('click',dlgCancel);
	$('#mytest').bind('click',mytest);
	
});
function mytest(){
//	var ids = [];
//	var rows = $('#dg').datagrid('getSelections');
//	for(var i=0; i<rows.length; i++){
//		ids.push(rows[i].email);
//	}
//	alert(ids.join('\n'));
	$('#mm').menu('show', {
		  left: 200,
		  top: 100
		});
}
function newUser(){
	$('#dlg').dialog('open').dialog('setTitle','New User');
	$('#fm').form('clear');
	url='book/addbook.do';
}
function editUser(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$('#dlg').dialog('open').dialog('setTitle','Edit User');
		$('#fm').form('load',row);
		url = 'book/editbook.do';
	}
}
function delUser(){
	var row = $('#dg').datagrid('getSelected');
	if (row){
		$.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){
			if (r){
				$.post('book/delbook.do',{firstname:row.firstname},function(result){
					if (result.success){
						$('#dg').datagrid('reload');
					} else {
						$.messager.show({
							title: 'Error',
							msg: result.errorMsg
						});
					}
				},'json');
			}
		});
	}	
}
function saveUser(){
	var v=$('#fm').form('validate');
	if(!$('#fm').form('validate')){
		return;
	}
	var data=$('#fm').serialize();
	$('#fm').form('submit',{
		url:url,
		success:function(result){
			var v = JSON.parse(result);
			if(v.errorMsg){
//				$.messager.show({
//					title: 'Error',
//					msg: v.errorMsg
//				});
				alert(v.errorMsg);
			}else{
				$('#dlg').dialog('close');
				$('#dg').datagrid('reload');
			}
		}
	});
}
function dlgCancel(){
	$('#dlg').dialog('close');
}
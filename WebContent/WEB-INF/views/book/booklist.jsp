<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
<%@ include file="../head.jsp"%>
</head>
<body>
<input value="aaaaaa" id="cc" title="test aaa" class="easyui-combotree" style="width:200px;"
    data-options="required:false,editable:true,multiple:true">
</input>
<a id="btn" href="#" title="test" class="easyui-linkbutton" data-options="iconCls:'icon-search'">easyui</a>
<input type="text" title="testbox" class="easyui-numberbox" value="100" data-options="min:0,precision:2">
<input id="dd" title="test dd" type="text" class="easyui-datetimebox" required="required">
<input id="ss" title="test ss" class="easyui-timespinner" style="width:80px;"
     data-options="min:'08:30',showSeconds:true">

<div id="win" closed="true" class="easyui-window" title="My Window" style="width:600px;height:400px"
    data-options="iconCls:'icon-save',modal:false">
    Window Content
</div>

<table id="dg" title="My Users" class="easyui-datagrid" style="width:550px;height:250px"
		toolbar="#toolbar" pagination="true" 
		fitColumns="true" singleSelect="false">
	<thead>
		<tr>
		<th field="ck" checkbox="true"></th>
			<th field="firstname" width="50" sortable="true">First Name</th>
			<th field="lastname" width="50" sortable="true">Last Name</th>
			<th field="phone" width="50" sortable="true">Phone</th>
			<th field="email" width="50" hidden sortable="true">Email</th>
		</tr>
	</thead>
</table>
	<div
		style="width: 200px; height: auto; background: #7190E0; padding: 5px;">
		<div class="easyui-panel" title="Picture Tasks" collapsible="true" collapsed="true"
			style="width: 200px; height: auto; padding: 10px;">
			<!-- tree -->
			<ul class="easyui-tree">
				<li><span>Folder</span>
								<li><span>File 11</span></li>
								<li><span>File 12</span></li>
								<li><span>File 13</span></li>
						<li><span>File 2</span></li>
						<li><span>File 3</span></li>
					</ul></li>
				<li><span>File21</span></li>
			</ul>
		</div>
		<br />
		<div class="easyui-panel" title="File and Folder Tasks"
			collapsible="true" style="width: 200px; height: auto; padding: 10px;">
			Make a new folder<br /> Publish this folder to the Web<br /> Share
			this folder
		</div>
		<br />

		<div id="result">aa</div>

		<div id="toolbar">
			<a href="#" id="addUser" class="easyui-linkbutton" iconCls="icon-add"
				plain="true">New User</a> <a href="#" id="editUser"
				class="easyui-linkbutton" iconCls="icon-edit" plain="true">Edit
				User</a> <a href="#" id="delUser" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true">Remove User</a> <a href="#"
				id="mytest" class="easyui-linkbutton" iconCls="icon-ok" plain="true">test</a>
		</div>

		<div id="dlg" class="easyui-dialog"
			style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
			buttons="#dlg-buttons">
			<div class="ftitle">User Information</div>
			<form id="fm" method="post">
				<div class="fitem">
					<label>First Name:</label> <input name="firstname"
						class="easyui-validatebox" required="true">
				</div>
				<div class="fitem">
					<label>Last Name:</label> <input name="lastname"
						class="easyui-validatebox" required="true">
				</div>
				<div class="fitem">
					<label>Phone:</label> <input name="phone">
				</div>
				<div class="fitem">
					<label>Email:</label> <input name="email"
						class="easyui-validatebox" validType="email">
				</div>
			</form>
		</div>
		<div id="dlg-buttons">
			<a href="#" id="saveUser" class="easyui-linkbutton" iconCls="icon-ok">Save</a>
			<a href="#" id="dlgCancel" class="easyui-linkbutton"
				iconCls="icon-cancel">Cancel</a>
		</div>


		<script src="js/app/book/book.js" type="text/javascript"></script>
</body>

</html>
var pageUrl = "/user/getUsers.html";
var deleteUrl = "/user/deleteUser.html";
var updateUrl = "/user/updateUser.html";

$(function(){
	queryFY();
});

function showTable(pageInfo){
    var total = pageInfo.total;//页总数
    var pageNum = pageInfo.pageNum;//页号
    var pageSize = pageInfo.pageSize;//页大小

    var users = pageInfo.list;
    $("#tbody").html("");//清空表格中数据并重新填充数据
    for(var i=0,length_1 = users.length;i<length_1;i++){
        var index = (pageNum - 1) * pageSize + i + 1;
        var tr = "<tr>"
            +'<td>'+index+'</td>'
            +'<td>'+replaceNull(users[i].username)+'</td>'
            +'<td>'+replaceNull(users[i].fullname)+'</td>'
            +'<td>'+replaceNull(users[i].sex)+'</td>'
            +'<td>'+replaceNull(users[i].email)+'</td>'
            +'<td>'+replaceNull(users[i].phone)+'</td>'
            +'<td>'+replaceNull(users[i].createtime)+'</td>'
            +'<td>'+replaceNull(users[i].roles)+'</td>'
            +'<td>';
        
        if (isAdmin()) {
        	tr+='<a href=javascript:void(0) title="点击修改用户" onclick="update('+users[i].id+')"><i class="layui-icon">&#xe642;</i></a>'
        	+'<a href=javascript:void(0) title="点击删除该用户" onclick="remove('+users[i].id+')"><i class="layui-icon">&#xe640;</i></a>';
        } else {
        	tr += "-";
        }
            
    	tr +='</td></tr>'
        $("#tbody").append(tr);
    }

    //开启分页组件
    showPage(total,pageNum,pageSize);
}
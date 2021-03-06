var pageUrl = "/message/page.html";
var deleteUrl = "/message/delete.html";
var updateUrl = "/message/update-custom.html";

$(function(){
	queryFY();
});

/**
 * 填充表格数据
 * @param pageInfo  ajax返回的参数信息
 */
function showTable(pageInfo) {
    var total = pageInfo.totalElements;//总数
    var pageNum = parseFloat(pageInfo.number)+1;//页号
    var pageSize = pageInfo.size;//页大小

    var beans = pageInfo.content;
    $("#tbody").html("");//清空表格中数据并重新填充数据
    for(var i=0,length_1 = beans.length;i<length_1;i++){
        var index = (pageNum - 1) * pageSize + i + 1;
        var tr = "<tr>"
            +'<td>'+index+'</td>'
            +'<td>'+replaceNull(beans[i].id)+'</td>'
            +'<td>'+replaceNull(beans[i].name)+'</td>'
            +'<td>'+replaceNull(beans[i].messageblank)+'</td>'
            +'<td>'+replaceNull(beans[i].createtime)+'</td>'
            +'<td>';
	        if(isAdmin()){
	        	tr+='<a href=javascript:void(0) title="修改" onclick="update(\''+beans[i].id+'\', 800, 400)"><i class="layui-icon">&#xe642;</i></a>'
	        		+'<a href=javascript:void(0) title="删除" onclick="remove(\''+beans[i].id+'\')"><i class="layui-icon">&#xe640;</i></a>'
	        }
            
	        tr+='<a href="/message/detail/'+beans[i].id+'" target="_blank" title="查看详情"><i class="layui-icon">&#xe615;</i></a>';
        	tr +='</td></tr>'
        		
        $("#tbody").append(tr);
    }

    //开启分页组件
    showPage(total, pageNum, pageSize);
}
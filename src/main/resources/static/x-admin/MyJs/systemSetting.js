var pageUrl = "/system-setting/page.html";
var deleteUrl = "/system-setting/delete.html";
var updateUrl = "/system-setting/update.html";

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
            +'<td>'+replaceNull(beans[i].settingKey)+'</td>'
            +'<td>'+replaceNull(beans[i].settingLabel)+'</td>'
            +'<td>'+replaceNull(beans[i].settingValue)+'</td>'
            +'<td>';
	        if(isAdmin()){
	        	tr+='<a href=javascript:void(0) title="修改" onclick="update(\''+beans[i].id+'\', 800, 400)"><i class="layui-icon">&#xe642;</i></a>'
	        }
            
        	tr +='</td></tr>'
        		
        $("#tbody").append(tr);
    }

    //开启分页组件
    showPage(total, pageNum, pageSize);
}
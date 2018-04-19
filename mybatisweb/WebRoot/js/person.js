function del(id) {
    if (confirm("确定删除吗？")) {
        var postUrl = basePath + "/index?opr=del&id=" + id;
        $.post(postUrl, callbackdel, "json");
    }
}
    function  add () {
        var postUrl=basePath + "/index?opr=add";
        var postData=$("#add").serializeObject();
        $.post(postUrl,postData,callbackadd,"json");
    }

    
    
    function update(id) {
        var postUrl=basePath+"/index?opr=update&id="+id;
        var postData=$("#update").serializeObject();
        $.post(postUrl,postData,callbackupdate,"json");
    }
    function callbackadd (data) {
        if(data==null){
            alert("添加失败");
        }else{
           alert("添加成功！")
            location.href=basePath+"/index"
        }
    }
    function callbackdel(data){
    	  if(data==null){
              alert("删除失败");
          }else{
             alert("删除成功！")
              location.href=basePath+"/index"
    }
    }
    function  callbackupdate(data) {
        if(data==null){
            alert("修改失败");
        }else{
            alert("修改成功！")
            location.href=basePath+"/index"
        }
    }



function f() {
    alert("这是一个f");
}
function Serch_id () {
    var s_id=$("#serch_id");
    var click_a=$("#serch_click");
    alert("开始ajax");
    $.ajax({
        type:"GET",
        url:[[@{/emps/{id}(id=s_id)}]],
        success:function a() {
        alert("查找成功");
        }
    });
}
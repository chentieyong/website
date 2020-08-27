var flag = false

function submitOneFeed() {
    if (flag == null) {
        return
    }
    flag = true
    $.ajax({
        type: 'post',
        url: basepath + '/submitOneFeed.json',
        data: $("#feed_form").serialize(),
        success: function (data) {
            flag = false
            if (data.success) {
                $('#feed_form')[0].reset()
                alert("提交成功")
            } else {
                alert(data.msg)
            }
        },
        error: function () {
            flag = false;
        }
    })
}
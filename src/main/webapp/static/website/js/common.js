$(function() {
	$('.navline').height($('.navlogo').height());
	$('.compinfobox').height($('.partbgimg').height());

	//返回顶部
	$(window).scroll(function() {
		var _top = $(window).scrollTop();
		if(_top > $('body').height()) {
			$('.backtotop').css('display', 'block');
			$('.contracticon,.contracttckbox').css('top', '0');
		} else {
			$('.backtotop').css('display', 'none');
			$('.contracticon').css('top', 'calc(50% + 50px)');
			$('.contracttckbox').css('top', '-80%');
		}
	});
	$('.backtotop').click(function() {
		$("html,body").animate({
			scrollTop: 0
		});
	});

	/*移动端导航栏切换*/
	var btnclick = 0;
	var navbutton = document.getElementById('navbtn');
	navbutton.addEventListener('click', function() {
		navbutton.classList.toggle("close");
		if(btnclick == 0) {
			$('.navbox').height($('body').height());
			$('.navbox').css('display', 'block');
			btnclick = 1;
		} else {
			$('.navbox').height(0);
			$('.navbox').css('display', 'none');
			btnclick = 0;
		}
	});

	$('.navbox .ul li').click(function() {
		$(".navbox .ul li").removeClass('on');
		$(this).addClass('on');
		$(this).children("ul.nav_droplist").slideToggle();
		$(this).siblings('li').children('.nav_droplist').slideUp();
	});

	//点击固定栏联系我们按钮
	var consclick = 0;
	$('.contracticon').click(function(event) {
		event.stopPropagation();
		if(consclick == 0) {
			var imgStr = basepath+"/static/website/img/lxkuang1.jpg"
			$(this).append("<div class=\"contracttckbox animated slideInRight\"><img src='"+imgStr+"'/></div>");
			if($('.contracticon').attr('style')=='top: 0px;'){
				$('.contracttckbox').css('top','0');
			}
			consclick = 1;
		}
	});
	$(document).on('click', 'body', function() {
		console.log(consclick);
		if(consclick == 1) {
			$('.contracttckbox').addClass('slideOutRight');
			setTimeout(() => {
				$('.contracttckbox').remove();
				consclick = 0;
			}, 500)
		}
	})

});
$(function() {
	$('.navline').height($('.navlogo').height());
	$('.compinfobox').height($('.partbgimg').height());

	//返回顶部
	$(window).scroll(function() {
		var _top = $(window).scrollTop();
		if(_top > 3000) {
			$('.backtotop').css('display', 'block');
		} else {
			$('.backtotop').css('display', 'none');
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

});
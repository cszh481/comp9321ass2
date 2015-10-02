var animateLock = 0;

$(window).scroll(function() {

    //when window size is larger than 992 (desktop), animated
    if (window.innerWidth > 992) {
    
        //at top of window
        if ($(window).scrollTop() == 0) {

            if (animateLock == 1) {
                animateLock = 0;
                $('#header').animate({height:"135px", paddingTop:"40px"});  
                
            }
        }
        
        else {
        
            if (animateLock == 0){
                animateLock = 1;
                $('#header').animate({height:"50px", paddingTop:"0px"});
               
            }
   
        }
    }
    //nav stay at fixed height when it's on small window
    else {
        $('#header').animate({height:"50px", paddingTop:"0px"});
    }

});
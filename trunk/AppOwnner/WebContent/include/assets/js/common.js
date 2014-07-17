function errorCheck(){
	if($('.ui-message-error').length==0){
				 
	}
}

function dialogBox(title,msg,btnclose,refresh){
	bootbox.dialog({closeButton:btnclose,title:title,
		message:msg,
		buttons:{
			success:{
				label:'Ok',
				callback:function(){
		if((refresh==null||refresh==undefined)?true:refresh)(window.location.href = window.location.href);}}}});
}

function nowild(event){
	try{
		if(event.keyCode ==32) return true;
	if((event.keyCode >= 37 && event.keyCode <=40)|| event.keyCode ==32) return;
	var temp = (event.target.value || event.srcElement.value).replace(/^\u0020*/g,"");
	temp = temp.replace(new RegExp("{|}|/|\\u005C|~|%|#|\\?|\"|\'","g"),"");tamper(event);
	commonApplySugarval(event,temp);}catch(e){console.log(e);}
}

function commonApplySugarval(event,temp){
	try{
	if(event.target)event.target.value = temp;
	if(event.srcElement)event.srcElement.value =temp;
	}catch(e){}
}

function trim(event){
	event = window.event | event;
	var temp = (event.target.value || event.srcElement.value).trim();
	commonApplySugarval(event,temp);
}

function initCaps(event){
	try{
	var temp = (event.target.value || event.srcElement.value).trim();
	temp = temp.substring(0,1).toUpperCase()+temp.substring(1,temp.length);
	commonApplySugarval(event,temp);}
	catch(e){}
}


function cent(idclass){
	$(idclass).css("position","fixed");
    $(idclass).css("top", Math.min(15, (($(window).height() - $(idclass).outerHeight()-$(window).scrollTop()) / 2))+"px");
    $(idclass).css("left", Math.max(0, (($(window).width() - $(idclass).outerWidth()-$(window).scrollLeft()) / 2)) +"px"); 
};
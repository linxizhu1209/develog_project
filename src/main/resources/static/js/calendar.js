    var CDate = new Date();
    var today = new Date();
    var selectCk = 0;

    var buildcalendar = function(){
    var htmlDates = '';
    var prevLast = new Date(CDate.getFullYear(), CDate.getMonth(), 0); //지난 달의 마지막 날
    var thisFirst = new Date(CDate.getFullYear(), CDate.getMonth(), 1); //이번 달의 첫쨰 날
    var thisLast = new Date(CDate.getFullYear(), CDate.getMonth() + 1, 0); //이번 달의 마지막 날
    document.querySelector(".month").innerHTML = (CDate.getMonth() + 1) + "월";  //month에 월 출력
    const dates = [];
    if(thisFirst.getDay()!==0){
    for(var i = 0; i < thisFirst.getDay(); i++){
    dates.unshift(prevLast.getDate()-i); // 지난 달 날짜 채우기
}
}
    for(var i = 1; i <= thisLast.getDate(); i++){
    dates.push(i); // 이번 달 날짜 채우기
}
    for(var i = 1; i <= 13 - thisLast.getDay(); i++){
    dates.push(i); // 다음 달 날짜 채우기 (나머지 다 채운 다음 출력할 때 42개만 출력함)
}

    for(var i = 0; i < 42; i++){
    if(i < thisFirst.getDay()){
    htmlDates += '<div class="date last">'+dates[i]+'</div>';
}else if(today.getDate()===dates[i] && today.getMonth()===CDate.getMonth() && today.getFullYear()===CDate.getFullYear()){
    htmlDates += '<div id="date_'+dates[i]+'" class="bi bi-heart" onclick="fn_selectDate('+dates[i]+');">'+dates[i]+'</div>';
}else if(i >= thisFirst.getDay() + thisLast.getDate()){
    htmlDates += '<div class="date next">'+dates[i]+'</div>';
}else{
    htmlDates += '<div id="date_'+dates[i]+'" class="date" onclick="fn_selectDate('+dates[i]+');">'+dates[i]+'</div>';
}
}
    document.querySelector(".dates").innerHTML = htmlDates;
}

buildcalendar();
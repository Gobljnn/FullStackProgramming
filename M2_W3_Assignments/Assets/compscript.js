function restart() {
    var $msgtop, $msgleft, $msgright, $msgbottom;
    var $msgtop2, $msgleft2, $msgright2, $msgbottom2 ;
    $msgtop= document.getElementById("top2")
    $msgtop.innerHTML = "";

    $msgleft= document.getElementById("left2").innerHTML = "";
    $msgright= document.getElementById("right2").innerHTML = "";
    $msgbottom= document.getElementById("bottom2").innerHTML = "";

    $msgtop2= document.getElementById("newtop").value="";
    $msgleft2= document.getElementById("newleft").value = "";
    $msgright2= document.getElementById("newright").value = "";
    $msgbottom2= document.getElementById("newbottom").value = "";    
}

function update() {
    var $msgtop2 = document.getElementById("newtop");
    var $msgtop = document.getElementById("top2");
    $msgtop.innerHTML = document.getElementById("newtop").value;

    var $msgleft2 = document.getElementById("newleft");
    var $msgtop = document.getElementById("left2");
    $msgtop.innerHTML = document.getElementById("newleft").value;

    var $msgright2 = document.getElementById("newright");
    var $msgtop = document.getElementById("right2");
    $msgtop.innerHTML = document.getElementById("newright").value;

    var $msgbottom2 = document.getElementById("newbottom");
    var $msgtop = document.getElementById("bottom2");
    $msgtop.innerHTML = document.getElementById("newbottom").value;
}

/* LMC - leftMiddleCell  TMC- topMiddleCell  RMC - rightMiddleCell  BMC - bottomMiddleCell*/
/* wn- West-Nort  we - West-East  se - South-East */
function wnSwitch() {
    var $LMC, $TMC, $sandbox1, $sandbox2;
   
    $LMC  = document.getElementById("left2").innerHTML;
    $TMC = document.getElementById("top2").innerHTML;
    
    $sandbox1= $LMC;
    $sandbox2 = $TMC;
    
    document.getElementById("left2").innerHTML = $sandbox2;
    document.getElementById("top2").innerHTML = $sandbox1;
   
}

function weSwitch() {
    var $LMC, $RMC, $sandbox1, $sandbox2;
   
    $LMC  = document.getElementById("left2").innerHTML;
    $RMC = document.getElementById("right2").innerHTML;
    
    $sandbox1= $LMC;
    $sandbox2 = $RMC;
    
    document.getElementById("left2").innerHTML = $sandbox2;
    document.getElementById("right2").innerHTML = $sandbox1;
   
}

function seSwitch() {
    var $BMC, $RMC, $sandbox1, $sandbox2;
   
    $BMC  = document.getElementById("bottom2").innerHTML;
    $RMC = document.getElementById("right2").innerHTML;
    
    $sandbox1= $BMC;
    $sandbox2 = $RMC;
    
    document.getElementById("bottom2").innerHTML = $sandbox2;
    document.getElementById("right2").innerHTML = $sandbox1;
   
}

function cChangeOn1(){
    const $boxcolour1= document.getElementById("compButton1");
    $boxcolour1.style.backgroundColor= '#91F892';
}

function cChangeOn2(){
    const $boxcolour2= document.getElementById("compButton2");
    $boxcolour2.style.backgroundColor= '#91F892';

}


function cChangeOn3(){
    const $boxcolour3= document.getElementById("compButton3");
    $boxcolour3.style.backgroundColor= '#91F892';
}

function cChangeOff1(){
    const $boxcolour1= document.getElementById("compButton1");
    $boxcolour1.style.backgroundColor= '#c2c7c9b4';
}

function cChangeOff2(){
    const $boxcolour2= document.getElementById("compButton2");
    $boxcolour2.style.backgroundColor= '#c2c7c9b4';
}

function cChangeOff3(){
    const $boxcolour3= document.getElementById("compButton3");
    $boxcolour3.style.backgroundColor= '#c2c7c9b4';
}

function lock(){
    var $msgtop2, $msgleft2, $msgright2, $msgbottom2 ;

    $msgtop2= document.getElementById("newtop").disabled=true;
    $msgleft2= document.getElementById("newleft").disabled=true;
    $msgright2= document.getElementById("newright").disabled=true;
    $msgbottom2= document.getElementById("newbottom").disabled=true;   
}

function unLock(){
    var $msgtop2, $msgleft2, $msgright2, $msgbottom2 ;

    $msgtop2= document.getElementById("newtop").disabled=false;
    $msgleft2= document.getElementById("newleft").disabled=false;
    $msgright2= document.getElementById("newright").disabled=false;
    $msgbottom2= document.getElementById("newbottom").disabled=false;   
}

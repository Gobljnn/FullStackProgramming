function calcRoots() {
    var textb1, textb2, textb3;
    var numa, numb, numc;
    var x1, x2;

    textb1 = document.getElementById("a");
    textb2 = document.getElementById("b");
    textb3 = document.getElementById("c");

    numa = textb1.value;
    numb = textb2.value;
    numc = textb3.value;

    /* 
    ax2+bx+c = 0
    -b +- (sqrt ((b^2) - (4ac))) / 2a
    */


    x1 =  parseFloat( ((-numb) + (Math.sqrt((numb**2)-(4*numa*numc))))/(2*numa) ).toFixed(1) ;
    x2 = parseFloat( ((-numb) - (Math.sqrt((numb**2)-(4*numa*numc))))/(2*numa) ).toFixed(3);
    
    if ( numa > -99 && numa < 99 && numb > -99 && numb < 99 && numc > -99 && numc < 99 && numa != 0  ){
        if ( (numb**2) < (4*numa*numc) ) {
            document.getElementById("output").innerHTML= "Solution roots are imaginary";
        }

        else if ( (numb**2) == (4*numa*numc) ) {
            document.getElementById("output").innerHTML = "Solution = " + x1;
        }

        else if ( (numb**2) > (4*numa*numc) ) {
            document.getElementById("output").innerHTML= "Solution = " + x1 + " and " + x2 + " are the solutions";
        }
    }

    else if ( numa < -99 || numa > 99) {
        document.getElementById("output").innerHTML= "";
        textb1.value = "";
        alert (" \'a\' needs to be in between -99 and +99 ");
    }
    else if (numa == 0) {
        document.getElementById("output").innerHTML= "";
        textb1.value = "";
        alert (" \'a\' cannot equal 0");
    }
    else if ( numb < -99 || numb > 99) {
        document.getElementById("output").innerHTML= "";
        textb2 = "";
        alert ("\'b\' needs to be in between -99 and +99 ");
}
    else if ( numc < -99 || numc > 99) {
        document.getElementById("output").innerHTML= "";
        textb3.value = "";
        alert ("\'c\' needs to be in between -99 and +99 ");   
    }
}

function cChangeOn() {
    const $boxcolour1= document.getElementById("calcButton");
    $boxcolour1.style.backgroundColor= 'rgba(132, 255, 0, 0.538)';
}

function cChangeOff() {
    const $boxcolour2= document.getElementById("calcButton");
    $boxcolour2.style.backgroundColor= 'rgba(128, 255, 0, 0.312)';
}
 

/*fff3f3 
e01a1a
*/



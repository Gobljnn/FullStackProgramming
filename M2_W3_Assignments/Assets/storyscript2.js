window.onload = function() {
    adLib();
}


function adLib() {
    var view = document.getElementById("adLib");
    view.style.display="none"; /* view.style["display"] = "none"; -- this works as well */
}

function cChangeOn1() {
    var $boxcolour1= document.getElementById("subButton");
    $boxcolour1.style.backgroundColor= 'rgba(132, 255, 0, 0.83)';
    var $boxcolour1= document.getElementById("retButton");
    $boxcolour1.style.backgroundColor= 'rgba(132, 255, 0, 0.83)';
}

function cChangeOn2() {
    var $boxcolour1= document.getElementById("resetButton");
    $boxcolour1.style.backgroundColor= 'rgba(255, 8, 0, 0.84)';
}

function cChangeOff() {
    var $boxcolour2= document.getElementById("subButton");
    $boxcolour2.style.backgroundColor= 'rgba(128, 255, 0, 0.312)';
    var $boxcolour2= document.getElementById("retButton");
    $boxcolour2.style.backgroundColor= 'rgba(128, 255, 0, 0.312)';
    var $boxcolour1= document.getElementById("resetButton");
    $boxcolour1.style.backgroundColor= 'rgba(255, 8, 0, 0.529)';
}

function genStory(form) {
    var view = document.getElementById("index");
    view.style.display="none";
    var view = document.getElementById("heading");
    view.style.display="none";
    var view2 = document.getElementById("errmsg");
    view.style.display="none";
    var view = document.getElementById("adLib");
    view.style.display="inline";
    var genText = document.getElementById("output");
    

    var word1 = document.getElementById("noun").value;
    var word2 = document.getElementById("ptv1").value;
    var word3 = document.getElementById("adject1").value;
    var word4 = document.getElementById("ptv2").value;
    var word5 = document.getElementById("adject2").value;

    if (word1 == "" || word2 == "" || word3 == "" ||
        word4 == "" || word5 == "") {
        
        genText.innerHTML = "It was a dark and stormy night. Suddenly, a shot rang out! A <span class=\"missing\">missing text</span> slammed. The maid <span class=\"missing\">missing text</span>. Suddenly, a <span class=\"missing\">missing text</span> ship appeared on the horizon! While millions of people were <span class=\"missing\">missing text</span>, the king lived in luxury. Meanwhile, on a <span class=\"missing\">missing text</span> farm in Kansas, a boy was growing up." 
        }

        else {
            genText.innerHTML = "It was a dark and stormy night. Suddenly, a shot rang out! A " + word1 + " slammed. The maid " + word2 + ". " + "Suddenly, a " + word3 + " ship appeared on the horizon! While millions of people were " + word4 +
        ", the king lived in luxury. Meanwhile, on a " + word5 + " farm in Kansas, a boy was growing up.";

        }

    
}


function goBack() {

    var view = document.getElementById("index");
    view.style.display="";
    var view = document.getElementById("heading");
    view.style.display="";
    view = document.getElementById("adLib");
    view.style.display="none";
    var genText = document.getElementById("output");

}


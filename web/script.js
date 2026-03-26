const calculateBtn = document.getElementById("calculate");
const clearBtn = document.getElementById("clear");

const principal = document.getElementById("principal");
const rate=document.getElementById("rate");
const tenure=document.getElementById("tenure");
const resultBox = document.getElementById("result");


// for refreshing: Check if any values in localStorage already
const savedP = localStorage.getItem("principal");
const savedR = localStorage.getItem("rate");
const savedN = localStorage.getItem("tenure");
const savedResult = localStorage.getItem("emiResult");

//if values in localStoarge already,load them
if(savedP) document.getElementById("principal").value = savedP;
if(savedR) document.getElementById("rate").value = savedR;
if(savedN) document.getElementById("tenure").value = savedN;
if(savedResult) document.getElementById("result").innerText = savedResult;

//click event for emi calculation button
calculateBtn.addEventListener("click", function(){
    //allow floating values
    const P = parseFloat(principal.value);
    const R = parseFloat(rate.value) / 12 / 100;
    const N = parseInt(tenure.value);
    resultBox.classList.add("active");


    if(P && R && N){   //check if all fields are filled

        if( P <= 0 || R <= 0 || N <= 0){
        resultBox.innerText = "Please enter valid positive numbers!";
        resultBox.classList.add("active");
        return; // for invalid values
    }
        const EMI = (P * R * Math.pow(1+R, N)) / (Math.pow(1+R, N) - 1);
        const resultText = `Your EMI is Rs.${EMI.toFixed(2)}`;
        resultBox.innerText = resultText;
        

        // Save inputs and result in localStorage
        localStorage.setItem("principal", P);
        localStorage.setItem("rate", R*12*100); 
        localStorage.setItem("tenure", N);
        localStorage.setItem("emiResult", resultText);
    } else {   //if any field not filled
        resultBox.innerText = "Please fill all fields!";
    }
});

//click event for clear button
clearBtn.addEventListener("click", function(){
    principal.value = "";
    rate.value = "";
    tenure.value = "";
    resultBox.classList.remove("active");

    // Clear localStorage
    localStorage.removeItem("principal");
    localStorage.removeItem("rate");
    localStorage.removeItem("tenure");
    localStorage.removeItem("emiResult");
});
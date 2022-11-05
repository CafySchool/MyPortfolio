(async function(){
    const URL = "http://localhost:8080/api/functionality/";

//input text
    const BANKCODEINPUT = document.getElementById("bankcode");
    const PANINPUT = document.getElementById("pan");
//checkbox element
    const CDMINPUT = document.getElementById("CDM");
    const CIMINPUT = document.getElementById("CIM");
    const RPRINPUT = document.getElementById("RPR");
    const IPMINPUT = document.getElementById("IPM");
    const KEYBOARDINPUT = document.getElementById("KEYBOARD");
//bottoni
    const SUBMITBUTTON = document.getElementById("submitButton");
    const CANCELBUTTON = document.getElementById("cancelButton");
//result div
    const RESULT = document.getElementById("resultDiv");
    
    const findCustom = async () => {
        if(BANKCODEINPUT.value != "" && PANINPUT.value != "" && BANKCODEINPUT.value.length == 5 && PANINPUT.value.length == 16) {
        try { 
            body = { 
                    "maskedPan": PANINPUT.value,
                    "bankCodeId": BANKCODEINPUT.value,
                    "idPeripheral": []   
            }
            if(CDMINPUT.checked)
            body["idPeripheral"].push(CDMINPUT.value);
            if(CIMINPUT.checked)
            body["idPeripheral"].push(CIMINPUT.value);
            if(RPRINPUT.checked)
            body["idPeripheral"].push(RPRINPUT.value);
            if(IPMINPUT.checked)
            body["idPeripheral"].push(IPMINPUT.value);
            if(KEYBOARDINPUT.checked)
            body["idPeripheral"].push(KEYBOARDINPUT.value);
                let response = await fetch(buildRequest(`${URL}findCustom`, 'POST', JSON.stringify(body)));
                //console.log(response)
                if(response.ok){
                    return await response.json();
                }
            throw({status: response.status, text: response.status})
        }catch (error) {
            console.log(error)
        }
    }
    }
    const deleteFunc = async (body) => {   
        try {
            let uri = `${URL}delete`;
            if (body) {
                uri += "/" + `${body}`;
            }
            let response = await fetch(buildRequest(uri, 'DELETE'));
        if(response.ok){
            return "funzione eliminata";
        }
            
        } catch (error) {
            console.log(error)
        }
    }  
    
    let table = SUBMITBUTTON.onclick = async () => {
        try {
            RESULT.innerHTML = "";
            let data = await findCustom();
            //console.log(data)
            let arr = Object.keys(data);
            //console.log(arr)
            let html = `<h1 id="functionalityTitle">Funzionalità disponibili</h1><br>
            <div id="peripherical">`
       /*  `<table>               
            <tr>
                <th>ID</th>
                <th>Nome</th> 
                <th>Descrizione</th>
                <th>Abilitata</th>
                <th>Tipo</th>
                <th>Multisessione</th>
                <th>Operazioni</th>
            </tr>` */
            arr.forEach(elem => {

                html += `
                <button class="periButton" >${data[elem].name}</button>`
                //if(!data[elem].name)
                

                //html += 
                /* `<tr>
                  <td>${data[elem].id}</td>
                  <td>${data[elem].name}</td>
                  <td>${data[elem].description}</td>
                  <td>${data[elem].enabled}</td>
                  <td>${data[elem].typeFunc}</td>
                  <td>${data[elem].multisession}</td>
                  <td>${data[elem].idBankCode}</td>
                  <td>${data[elem].idBin}</td>
                  <td>${data[elem].idPeripheral}</td>
                  <td>${data[elem].idParameter}</td>
                  <td><button id="${data[elem].id}" class="deletebutton">Elimina</button></td>
                </tr>` */
                
            })
            
            RESULT.innerHTML = html + `</div>`//+ `</table>`
            await delElem();
            
        } catch(error) {
            RESULT.innerHTML = `<img class="logo" src="img/close.png">
            <br>
            <h2>ATTENZIONE<h2>
            <h3 class="error">Inserire correttamente i dati</h3>`;
        }
    } 
       
    CANCELBUTTON.onclick =  () => {
            RESULT.innerHTML = "";
            RESULT.innerHTML += `<marquee behavior="scroll" direction="left"><h2>IN ATTESA DI OPERAZIONE...</h2></marquee>
            <br><br><br><br>
                <img src="img/apulia_logo.png" alt="">`
    }   
    
     const delElem = async() => {
        let buttonDel = document.getElementsByClassName("deletebutton");
        for(let i=0; i<buttonDel.length; i++){
            buttonDel[i].addEventListener('click', async function(){
                let idd = this.id;
                await deleteFunc(idd);
                await table();
            })
        }
        
        } 

        function buildRequest(URL, method = "GET", body = null){
            let headers = new Headers({
                "Accept":"application/json",
                "Content-Type":"application/json",
            });
    
            return new Request(URL, {
                method: method,
                headers: headers,
                body: body
            })
        }
})();


function isNumberKey(evt){
    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}
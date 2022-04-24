
function sendApplication(){
    
    document.getElementById('form-zone').style.display = 'none';
    
    let lanetakere = [];
    let lanebelop = document.getElementById('lanebelop').value;
    let behov = document.getElementById('behov').value;
    let lopetid = document.getElementById('lopetid').value;
    let avdragsfriPeriode = document.getElementById('avdradsfriPeriode').value;
    let typedrowdown = document.getElementById('type');
    let type = typedrowdown.options[typedrowdown.selectedIndex].value;
    
    let lanetakerliste = document.getElementById('laantaker-div').getElementsByClassName('laantaker-linje');
    let listelengde = lanetakerliste.length;
    for(let a = 0;a < listelengde;a++){
        let parent = lanetakerliste[a];
        let navn = parent.getElementsByClassName('borrower-name')[0].value;
        let fnr = parent.getElementsByClassName('borrower-fnr')[0].value;
        lanetakere.push({ navn: navn, fnr: navn});
    }
    
    let json = {lanetakere:lanetakere, lanebelop:lanebelop, behov:behov, lopetid:lopetid, avdragsfriPeriode: avdragsfriPeriode, type:type};
    
    let post = JSON.stringify(json);
 
    const url = "/rest";
    let xhr = new XMLHttpRequest();
 
    xhr.open('POST', url, true);
    xhr.setRequestHeader('Content-type', 'application/json; charset=UTF-8');
    
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            let response = this.responseText;
            let resp = JSON.parse(response);
            
            let responseElement = document.getElementById('response-zone');
            responseElement.innerHTML = "<div>Løpenummer på søknad: " + resp.applicationID + "</div><div>Status: " + resp.status  + "</div>";
            responseElement.style.display = 'block';
            
            console.log(response);
        }
    };
    
    xhr.send(post);   
    
}

function add(){
    
    let basicElement = document.getElementById('borrower-element-holder').getElementsByClassName('laantaker-linje')[0];
    let newNode = basicElement.cloneNode(true);
    document.getElementById('laantaker-div').appendChild(newNode);
    
}

function remove(element){
    
    let headElement = element.closest('.laantaker-linje');
    headElement.parentElement.removeChild(headElement);
    
}
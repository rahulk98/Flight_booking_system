function formFormat() {
    if (document.getElementById('oneway').checked) {

        document.getElementById('return_date').style.display = 'none';
    }
    else {

        document.getElementById('return_date').style.display = 'block';
        
        
    }
}

function validation(form) {
    if (form.source.value == "") {
        alert("Source city cannot be empty");
        form.source.focus();
        return false;
    }
    if (form.destination.value == "") {
        alert("Destination city cannot be empty");
        form.destination.focus();
        return false;
    }
    if (form.journey_date == "") {
        alert("Journey date cannot be empty");
        form.journey_date.focus();
        return false;
    }
    return true;
    
}
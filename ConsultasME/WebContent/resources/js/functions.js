function pone_dv(rutin,e) {
     var m=2;
     var sum=0;
     for (var i=rutin.length-1; i >= 0;i--) {
         sum+=rutin.charAt(i)*m;
         m++;
         if (m>7) { m=2 }
     }
     var dig=sum%11;
     dig=11-dig;
     if (dig==11) { dig=0 };
     if (dig==10) { dig="K"};
     document.forms[0].elements[e].value=dig;
   }
   
function fechaActual() {
    var temp = new Date();
	agno = temp.getFullYear();
    agnoHasta = temp.getFullYear();
    dia = temp.getDate();
    mes = temp.getMonth();
    mesHasta = temp.getMonth()+1;     
    if (dia<10) { dia = "0"+dia; }
    if (mes<10) { mes = "0" + mes; }
    if (mes<1) 
    { 
        mes = 12;
        mesHasta = 1
        agno =  (agno*1)-1;
    }    
    if (mesHasta<10) { mesHasta = "0" + mesHasta; }
    
    document.getElementById('anoDesde').value=agno;
    document.getElementById('anoHasta').value=agnoHasta;
    document.getElementById('diaDesde').value=dia;
    document.getElementById('diaHasta').value=dia;
    document.getElementById('mesDesde').value=mes;
    document.getElementById('mesHasta').value=mesHasta;

} 

function llenaFecha(a,d,m) {
    if (a=="" || d=="" || m=="") {
        var temp = new Date();
        agno = temp.getFullYear();
        dia = temp.getDay();
        mes = temp.getMonth();
        if (dia<10) { dia = "0"+dia; }
        if (mes<10) { mes = "0" + mes; }
        document.rectificadosForm.anoHasta.value=agno;
        document.rectificadosForm.diaHasta.value=dia;
        document.rectificadosForm.mesHasta.value=mes;
    }
}   

function enviaForm(form,nombre,f){
    form.name=nombre
    form.action=f;
    form.submit();
}

function limpiar(){
    document.forms[0].anoHasta.value="";
    document.forms[0].diaHasta.value="";
    document.forms[0].mesHasta.value="";
    document.forms[0].anoDesde.value="";
    document.forms[0].diaDesde.value="";
    document.forms[0].mesDesde.value="";
    document.forms[0].rut.value="";
    document.forms[0].dv.value="";
}


function LimitAttach(tField,iType)
{
    file=tField.value;
    
    if (iType==1) {
        extArray = new Array(".gif",".jpg",".png");
    }
    if (iType==2) {
        extArray = new Array(".swf");
    }
    if (iType==3) {
        extArray = new Array(".exe",".sit",".zip",".tar",".swf",".mov",".hqx",".ra",".wmf",".mp3",".qt",".med",".et");
    }
    if (iType==4) {
        extArray = new Array(".mov",".ra",".wmf",".mp3",".qt",".med",".et",".wav");
    }
    if (iType==5) {
        extArray = new Array(".html",".htm",".shtml");
    }
    if (iType==6) {
        extArray = new Array(".xls",".csv");
    }
    if (iType==7) {
        extArray = new Array(".txt");
    }

    allowSubmit = false;
    
    if(!file) 
        return false;
        
    while (file.indexOf("\\") != -1) file = file.slice(file.indexOf("\\") + 1);
    ext = file.slice(file.indexOf(".")).toLowerCase();
    for (var i = 0; i < extArray.length; i++) {
        if (extArray[i] == ext) {
            allowSubmit = true;
            break;
        }
    }

    if (!allowSubmit) {
        alert("Debe subir archivos con extensiones " + (extArray.join(" ")) + "\nPor favor seleccione un archivo correcto");
    }
}

function obligaArchivo(form)
{
    var formulario = document.getElementById("form");
    if(formulario.archivo.value.replace(/ /g, '') == '') 
    {
        alert("Campo Archivo obligatorio");
        return false;
    }
    form.submit();
}
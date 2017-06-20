//ÖØÖÃtextÖÃ£¬ÖÃÎª¿Õ
function resettext()
{
	var inputs = document.getElementsByTagName("INPUT");
	for(i=0;i<inputs.length;i++){
		if(inputs[i].type == 'text'){
			inputs[i].value="";
		}
	}
}
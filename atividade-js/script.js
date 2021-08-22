function VerificarImc() {
    var altura = parseFloat(document.getElementById("altura").value);
    var peso = parseFloat(document.getElementById("peso").value);
    var nome = document.getElementById("nome").value

    var imc = peso / (altura * altura);
    var imc = imc.toFixed(2);
    if (imc < 18.5) {
        resultado = nome + ", seu IMC é de " + imc + " e você está abaixo do peso ideal";
    }
    if (imc >= 18.5 && imc < 25) {
        resultado = nome + ", seu IMC é de " + imc + " e você está no peso ideal";
    }
    if (imc >= 25 && imc <= 30) {
        resultado = nome + ", seu IMC é de " + imc + " e você está acima do peso ideal";
    }
    if (imc > 30) {
        resultado = nome + ", seu IMC é de " + imc + " e você está obeso(a)";
    }

    document.getElementById("result").innerHTML = resultado;
}
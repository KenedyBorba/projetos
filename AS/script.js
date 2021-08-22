function Verificar() {
    var nota1 = parseFloat(document.getElementById("nota1").value);
    var nota2 = parseFloat(document.getElementById("nota2").value);
    var nota3 = parseFloat(document.getElementById("nota3").value);
    var nota4 = parseFloat(document.getElementById("nota4").value);
    var nota5 = parseFloat(document.getElementById("nota5").value);
    var nota6 = parseFloat(document.getElementById("nota6").value);

    var media = (nota1 + nota2 + nota3 + nota4 + nota5 + nota6) / 6;
    var media = media.toFixed(2);
    if (media >= 0 && media <= 10) {
        resultado = "De acordo com as notas que você deu para cada cena a média é " + media;
    }
    else {
        resultado = "Ocorreu algum erro. Confira novamente todas as notas e veja se todas foram digitadas corretamente."
    }

    document.getElementById("result").innerHTML = resultado;
}
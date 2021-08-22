$(document).ready(function () {
    home();

    $('#home').click(function () {
        home();
    })

    $('#about').click(function () {
        about();
    })

    $('#contact').click(function () {
        contact();
    })
});

function home() {
    $('section').html(`
<div class="row">
    <div class="col-md-12">
        <h2>Bem vindo</h2>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Blanditiis dolorem eligendi iusto commodi
            libero error asperiores assumenda qui inventore delectus illum natus reprehenderit, nesciunt quam,
            minima debitis. Eius ducimus voluptatibus perferendis animi nostrum, beatae, explicabo sunt possimus
            porro dicta, sed veniam adipisci! Cumque accusantium, modi unde obcaecati officia dignissimos
            exercitationem!
            Culpa aliquid laboriosam sit, neque architecto sequi animi suscipit incidunt inventore provident
            voluptas cumque. Molestias eveniet tempora delectus assumenda cumque soluta sapiente pariatur enim
            necessitatibus quasi illum ullam earum aliquam excepturi rem eaque, a nihil deleniti similique cum
            accusamus praesentium voluptatem facilis! Quae facilis mollitia id quod voluptatibus ducimus
            voluptatem.</p>
    </div>
</div>
<div class="row">
    <div class="col-md-3">
        <h2>Imagem um</h2>
        <img src="assets/img/image2.jpg" width="320" height="205" >
    </div>
    <div class="col-md-3">
        <h2>Imagem dois</h2>
        <img src="assets/img/image2.jpg" width="320" height="205" > 
    </div>
    <div class="col-md-3">
        <h2>Imagem três</h2>
        <img src="assets/img/image2.jpg" width="320" height="205" > 
    </div>
    <div class="col-md-3">
        <h2>Imagem quatro</h2>
        <img src="assets/img/image2.jpg" width="320" height="205" > 
    </div>
</div>
    `);
}

function about() {
    $('section').html(`     
    <div class="row">
    <div class="col-md-12">
        <h2>Sobre minha página</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Non facere magni totam ducimus nulla nesciunt, 
        recusandae enim eum minus officiis sint ratione voluptatum natus nihil consequatur excepturi nam velit. Facere!</p>
    </div>
</div>   
    <div class="row">
    <div class="col-md-3">
        <h2>Imagem um</h2>
        <img src="assets/img/image3.jpg" width="320" height="205" >
    </div>
    <div class="col-md-3">
        <h2>Imagem dois</h2>
        <img src="assets/img/image3.jpg" width="320" height="205" > 
    </div>
    <div class="col-md-3">
        <h2>Imagem três</h2>
        <img src="assets/img/image3.jpg" width="320" height="205" > 
    </div>
    <div class="col-md-3">
        <h2>Imagem quatro</h2>
        <img src="assets/img/image3.jpg" width="320" height="205" > 
    </div>
</div>
`);
}

function contact() {
    $('section').load('views/contact.html');
}
/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.addEventListener("DOMContentLoaded", () => {
    const btnCadastrar = document.getElementById("BtnAtualizar");

    if (btnCadastrar) {
        btnCadastrar.addEventListener("click", () => {
            window.location = "../atualizarProjetos.jsp"; // Página que você quer abrir
        });
    }
});

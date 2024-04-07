const appMenu = document.querySelector("#app_menu");
const btnToggleLayout = document.querySelector("#btn_toggle_layout");
const btnDeleteController = document.querySelectorAll(".delete-controller")
const dateShowEls = document.querySelectorAll("td[data-dateformat]") 
const fileUploader = document.querySelectorAll("input[data-fileuploader]");

function resetMenus(){
    const menus = appMenu.querySelectorAll('.app_menu_item')
    menus.forEach(el => {
        if(el.classList.contains('menu_active')) el.classList.remove('menu_active');
    })

}

function handleAppLoad(){
    resetMenus();
    const currentPath = location.pathname.split('/')[1];
    const currentMenuitem = appMenu.querySelector(`#${currentPath}_mgmt`)
    currentMenuitem.classList.add('menu_active');
    dateShowEls.forEach(el => {
        const dateValue = el.getAttribute("data-value");
        if(dateValue) {
            el.textContent = new Date(dateValue).toLocaleString()
        }
    })
}


window.addEventListener('load',handleAppLoad)
btnToggleLayout.addEventListener('click',()=>{
    document.body.classList.toggle('inactive_layout');
})

btnDeleteController.forEach(e => {
    e.addEventListener("click",event=>{
        const isConfirm = confirm(`Are you sure you want to delete ${e.getAttribute('data-name')}`)
        if(!isConfirm) event.preventDefault();
    })
})

fileUploader.forEach(el=>{
    el.addEventListener("change",(event)=>{
        const imageElement = document.querySelector(`img[data-target=${el.id}]`);
        if(imageElement) {
            const file = event.currentTarget.files?.[0]
            const reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = ()=>{
                imageElement.src = reader.result;
            }
        }
    })
})


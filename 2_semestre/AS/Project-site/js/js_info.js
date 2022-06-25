
        const storageInput = document.querySelector("#aname");
        const storageInput1 = document.querySelector("#aweight");
        const storageInput2 = document.querySelector("#aage");
        const storageInput3 = document.querySelector("#araca");
        const storageInput4 = document.querySelector("#adiagnose");
        const text = document.querySelector("#pet_name");
        const text1 = document.querySelector("#pet_weight");
        const text2 = document.querySelector("#pet_age");
        const text3 = document.querySelector("#pet_raca");
        const text4 = document.querySelector("#pet_diagnose");
        const button = document.querySelector("#button_add");
        const storedInput = localStorage.getItem('textinput')
        const storedInput1 = localStorage.getItem('textinput1')
        const storedInput2 = localStorage.getItem('textinput2')
        const storedInput3 = localStorage.getItem('textinput3')
        const storedInput4 = localStorage.getItem('textinput4')

        if(storageInput){
            text.textContent = storedInput
        }

        if(storageInput1){
            text1.textContent = storedInput1
        }

        if(storageInput2){
            text2.textContent = storedInput2
        }

        if(storageInput3){
            text3.textContent = storedInput3
        }

        if(storageInput4){
            text4.textContent = storedInput4
        }

        storageInput.addEventListener('input', letter => {
            text.textContent = letter.target.value
        })

        storageInput1.addEventListener('input', letter => {
            text1.textContent = letter.target.value
        })

        storageInput2.addEventListener('input', letter => {
            text2.textContent = letter.target.value
        })

        storageInput3.addEventListener('input', letter => {
            text3.textContent = letter.target.value
        })

        storageInput4.addEventListener('input', letter => {
            text4.textContent = letter.target.value
        })

        const saveToLocalStorage = () => {
            localStorage.setItem('textinput', text.textContent),
            localStorage.setItem('textinput1', text1.textContent),
            localStorage.setItem('textinput2', text2.textContent),
            localStorage.setItem('textinput3', text3.textContent),
            localStorage.setItem('textinput4', text4.textContent)
        }

        button.addEventListener('click', saveToLocalStorage)
  

 
        document.querySelector("#myFileInput").addEventListener("change", function(){
            const reader = new FileReader();

            reader.addEventListener("load", () => {
                localStorage.setItem("recent-image", reader.result);
            });

            reader.readAsDataURL(this.files[0]);
        });

        document.addEventListener("DOMContentLoaded", () => {
            const recentImageDataUrl = localStorage.getItem("recent-image");

            if (recentImageDataUrl){
                document.querySelector("#imgPreview").setAttribute("src", recentImageDataUrl);
            }
        });

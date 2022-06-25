import selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.chrome.options import Options
import time
import os

driver = webdriver.Chrome(
    executable_path="/Users/2001d/Desktop/chromedriver"
)

driver.get("https://diogofontes01.github.io/AS-PET.github.io/AS/index.html")
f = open("results.txt", "a")
driver.maximize_window()
time.sleep(1)



driver.find_element(By.ID,'ourservices').click()
time.sleep(1)

driver.find_element(By.ID,'standard').click()
time.sleep(1)
#driver.switch_to.frame("textarea_iframe")

#Register
driver.find_element(By.ID,"exampleFirstName").send_keys("firstname")
time.sleep(1)

driver.find_element(By.ID,"exampleLastName").send_keys("lastname")
time.sleep(1)

driver.find_element(By.ID,"exampleInputEmail").send_keys("lastname@ua.pt")
time.sleep(1)

driver.find_element(By.ID,"exampleInputPassword").send_keys("123")
time.sleep(1)

driver.find_element(By.ID,"exampleRepeatPassword").send_keys("123")
time.sleep(1)

driver.find_element(By.ID,"Morada").send_keys("Rua 123")
time.sleep(1)

driver.find_element(By.ID,"CodigoPostal").send_keys("123-345")
time.sleep(1)

driver.find_element(By.ID,"Telemovel").send_keys("989090909")
time.sleep(1)

driver.find_element(By.ID,"RegisterAccount").click()
time.sleep(1)

driver.find_element(By.ID,"mbway").click()
time.sleep(1)

f.write("Registo feito. Compra por mbway !!\n")



#Chat
driver.find_element(By.ID,"funcionarios").click()
time.sleep(1)

driver.find_element(By.ID,"veterinarios").click()
time.sleep(1)

driver.find_element(By.ID,"seeDiana").click()
time.sleep(1)

element = driver.find_element(By.CLASS_NAME,'joao')
driver.execute_script("arguments[0].click();", element)

#driver.find_element(By.CLASS_NAME,'joao').click()
time.sleep(1)

driver.find_element(By.ID,"textchat").send_keys("hello")
time.sleep(1)

driver.find_element(By.ID,"enviar-chat").click()
time.sleep(1)

driver.find_element(By.ID,"sairchat").click()
time.sleep(1)

f.write("Usou Chat\n")

#Adicionar Animal
driver.find_element(By.ID,"navlogin").click()
time.sleep(1)

element = driver.find_element(By.ID,"adicionar-animal")
driver.execute_script("arguments[0].click();", element)

time.sleep(1)

driver.find_element(By.ID,"aname").send_keys("Faisca")
time.sleep(1)

driver.find_element(By.ID,"aweight").send_keys("20")
time.sleep(1)

driver.find_element(By.ID,"aage").send_keys("4")
time.sleep(1)

driver.find_element(By.ID,"araca").send_keys("pitbull")
time.sleep(1)

driver.find_element(By.ID,"adiagnose").send_keys("perna partida")
time.sleep(1)

driver.find_element(By.ID,"btn-pet").click()
time.sleep(1)

f.write("Adicionou animal\n")


f.write("Teste concluído\n")


print (os.path.abspath("results.txt"))
f.close()
driver.quit();
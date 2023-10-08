""" 
Autor: Miguel Angel Alejandro Torruco
Fecha: 06/09/23
"""

# Versiones de las funciones sin usar recursividad, solo para entender la premisa

def imprimir_digitos(num: int):
    # Lo convertimos a cadena
    num = str(num)

    for i in range(len(num)):
        print(num[i])

def imprimir_reversa(cadena: str):
    tamano = len(cadena)

    for i in range(tamano - 1, -1, -1):
        print(cadena[i])

# Usando la recursividad

""" 
Retornar el primer dígito de la cadena más la llamada a la función pero con una cadena a la que
se le quite el dígito actual
Termina cuando la cadena termina siendo una cadena vacía
Se usa la notación de "1:", que significa toda la cadena menos el primer elemento, es decir, empezando en la posición 1, 
que es el segundo caracter
"""
def imprimir_digitos_recursiva(num: int) -> str:
    # Lo convertimos a cadena para manejarlo mejor
    num = str(num)

    # Si es una cadena vacía
    if not num: 
        return None
    # Si tiene solo una cifra
    if len(num) == 1:
        return num
    
    return num[0] + "\n" + imprimir_digitos_recursiva(num[1:])

"""  
La función toma de parámetro un número entero y devuelve un entero que corresponde al factorial del número
El factorial se calcula con la multiplicación del número actual por la llamada a la función con el número
en una unidad menos. Cuando se llegue al 0, se retorna 1 y para las recursiones
"""
def factorial_recursivo(num: int) -> int:
    if num < 0: 
        return None
    if num == 0: 
        return 1

    return num * factorial_recursivo(num - 1)

""" 
Usamos la misma lógica que se usó para la función de impresión normal, solo que se va imprimiendo el último elemento
usando la posición -1, que significa el último elemento. Después, se llama a la función ahora con la cadena sin el último
elemento, usando la notación de rebanadas ":-1", que significa toda la cadena menos el último caracter
"""
def imprimir_reversa_recursiva(cadena: str) -> str:
    # Si es una cadena vacía
    if not cadena: 
        return None
    # Si tiene solo una cifra
    if len(cadena) == 1:
        return cadena

    return cadena[-1] + "\n" +imprimir_reversa_recursiva(cadena[:-1])

# Función principal donde se prueban todas las funciones
def main():
    num1 = int(input("Digite un número entero, para imprimir los dígitos por separado: "))
    print(imprimir_digitos_recursiva(num1))

    num2 = int(input("Digite un número entero positivo para calcularle el factorial: "))
    print(f"El factorial de {num2} es: {factorial_recursivo(num2)}")
    
    cadena = input("Digite la cadena para imprimir sus caracteres al revés: ")
    print(imprimir_reversa_recursiva(cadena))

main()
![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# 🧠 Actividad Sumativa 3 – Interfaces e integración con colecciones genéricas

## 👤 Autor del proyecto

* **Nombre completo:** Marcos Alexis Escobar Avila
* **Sección:** 007A
* **Carrera:** Analista Programador Computacional

---

## 📘 Descripción general del sistema

Este proyecto corresponde a la continuación del desarrollo de la aplicación `LlanquihueTourApp`, realizada en el contexto de la asignatura Desarrollo Orientado a Objetos I.

El objetivo de esta actividad es ampliar el sistema de la agencia ficticia Llanquihue Tour mediante la incorporación de interfaces, herencia, polimorfismo, colecciones genéricas y validación de tipos utilizando el operador `instanceof`.

---

## 🎯 Objetivo de la actividad

Aplicar los principios de la Programación Orientada a Objetos mediante:

* La creación de una interfaz de comportamiento común.
* La implementación de la interfaz `Registrable`.
* La creación de subclases especializadas.
* El uso de polimorfismo para gestionar objetos de diferentes clases.
* El almacenamiento de objetos mediante `ArrayList<Registrable>`.
* La identificación del tipo real de los objetos utilizando `instanceof`.

---

## 🧱 Estructura general del proyecto

```plaintext
📁 src/
├── main/
│   ├── java/
│   │   └── com/llanquihuetour/tours/
│   │       ├── data/
│   │       │   ├── GestorDatos.java
│   │       │   ├── GestorServicios.java
│   │       │   └── GestorEntidades.java
│   │       │
│   │       ├── model/
│   │       │   ├── Tour.java
│   │       │   ├── ServicioTuristico.java
│   │       │   ├── RutaGastronomica.java
│   │       │   ├── PaseoLacustre.java
│   │       │   ├── ExcursionCultural.java
│   │       │   ├── Registrable.java
│   │       │   ├── RecursoAgencia.java
│   │       │   ├── GuiaTuristico.java
│   │       │   ├── Vehiculo.java
│   │       │   └── ColaboradorExterno.java
│   │       │
│   │       ├── service/
│   │       │   └── TourService.java
│   │       │
│   │       └── ui/
│   │           └── Main.java
│   │
│   └── resources/
│       └── tours.xlsx
```

---

## 🧩 Clases e interfaces creadas o modificadas

## Registrable

**Descripción:**

Interfaz ubicada en el paquete `model`, utilizada como contrato común para todas las entidades que pueden ser gestionadas por el sistema.

**Método declarado:**

```java
String mostrarResumen();
```

**Responsabilidad:**

Obligar a las clases que implementan esta interfaz a definir el método `mostrarResumen()`.

Gracias a esta interfaz, objetos de diferentes clases pueden ser almacenados y gestionados mediante una referencia común de tipo `Registrable`.

---

## RecursoAgencia

**Descripción:**

Clase base abstracta que representa un recurso general perteneciente a la agencia Llanquihue Tour.

**Implementa:**

```java
Registrable
```

**Atributo común:**

* `nombre`

**Responsabilidad:**

Contener los atributos y comportamientos compartidos por las entidades del sistema.

Esta clase permite aplicar herencia y evitar la repetición del atributo `nombre` en las clases hijas.

Al ser una clase abstracta, no se crean objetos directamente de `RecursoAgencia`. En su lugar, se crean objetos de sus subclases.

---

## GuiaTuristico

**Hereda de:**

```java
RecursoAgencia
```

**Atributos específicos:**

* `rut`
* `especialidad`
* `aniosExperiencia`

**Responsabilidad:**

Representar a los guías turísticos que trabajan en la agencia y almacenar información relacionada con su identificación, especialidad y experiencia.

**Implementación de la interfaz:**

Sobrescribe el método `mostrarResumen()` para mostrar la información correspondiente al guía turístico.

Ejemplo de resumen:

```plaintext
Tipo: Guía turístico
Nombre: Ana Pérez
RUT: 12.345.678-9
Especialidad: Turismo cultural
Años de experiencia: 5
```

---

## Vehiculo

**Hereda de:**

```java
RecursoAgencia
```

**Atributos específicos:**

* `patente`
* `tipoVehiculo`
* `capacidadPasajeros`

**Responsabilidad:**

Representar los vehículos utilizados por la agencia para transportar pasajeros durante las actividades turísticas.

**Implementación de la interfaz:**

Sobrescribe el método `mostrarResumen()` para mostrar la información correspondiente al vehículo.

Ejemplo de resumen:

```plaintext
Tipo: Vehículo
Nombre: Minibús turístico
Patente: ABCD12
Tipo de vehículo: Minibús
Capacidad de pasajeros: 15
```

---

## ColaboradorExterno

**Hereda de:**

```java
RecursoAgencia
```

**Atributos específicos:**

* `empresa`
* `servicioPrestado`

**Responsabilidad:**

Representar personas o empresas externas que prestan servicios para la agencia Llanquihue Tour.

**Implementación de la interfaz:**

Sobrescribe el método `mostrarResumen()` para mostrar la información correspondiente al colaborador externo.

Ejemplo de resumen:

```plaintext
Tipo: Colaborador externo
Nombre: Pedro González
Empresa: Transportes del Sur
Servicio prestado: Transporte turístico
```

---

## GestorEntidades

**Descripción:**

Clase perteneciente al paquete `data`, encargada de administrar las entidades registradas en el sistema.

**Colección utilizada:**

```java
private ArrayList<Registrable> entidades;
```

**Responsabilidades:**

* Crear y mantener la colección de entidades.
* Agregar objetos que implementen la interfaz `Registrable`.
* Almacenar diferentes tipos de entidades en una misma colección.
* Recorrer la colección mediante un ciclo `for-each`.
* Mostrar el resumen de cada entidad.
* Identificar el tipo real de cada objeto utilizando `instanceof`.
* Aplicar mensajes o lógica diferenciada dependiendo del tipo de entidad.
* Informar cuando no existen registros almacenados.

La colección puede almacenar objetos como:

```java
GuiaTuristico
Vehiculo
ColaboradorExterno
```

Esto es posible porque todas estas clases son consideradas objetos de tipo `Registrable`.

---

## Main

**Descripción:**

Clase principal de la aplicación ubicada en el paquete `ui`.

**Responsabilidades:**

* Iniciar la ejecución del sistema.
* Crear una instancia de `GestorEntidades`.
* Mostrar el menú principal mediante `JOptionPane`.
* Permitir el registro de guías turísticos.
* Permitir el registro de vehículos.
* Mostrar las entidades registradas.
* Validar los datos ingresados por el usuario.
* Controlar la cancelación de los formularios.
* Capturar errores durante la ejecución.
* Permitir cerrar correctamente la aplicación.

El menú principal contiene las siguientes opciones:

```plaintext
1. Registrar guía turístico
2. Registrar vehículo
3. Mostrar registros
4. Salir
```

---

## 🧠 Conceptos aplicados

### Interfaz

La interfaz `Registrable` establece un comportamiento común para las entidades gestionadas por la agencia.

```java
public interface Registrable {
    String mostrarResumen();
}
```

Toda clase que implemente esta interfaz debe definir su propia versión del método `mostrarResumen()`.

Esto permite trabajar con objetos de diferentes clases utilizando una referencia común.

---

### Polimorfismo

El polimorfismo se aplica al almacenar objetos de distintas clases en una colección común:

```java
ArrayList<Registrable> entidades = new ArrayList<>();
```

Dentro de esta colección se pueden almacenar diferentes objetos:

```java
entidades.add(new GuiaTuristico(...));
entidades.add(new Vehiculo(...));
entidades.add(new ColaboradorExterno(...));
```

Posteriormente, los objetos pueden recorrerse utilizando una referencia de tipo `Registrable`:

```java
for (Registrable entidad : entidades) {
    entidad.mostrarResumen();
}
```

Aunque la variable `entidad` es de tipo `Registrable`, Java ejecuta automáticamente la implementación de `mostrarResumen()` correspondiente a la clase real del objeto.

Por ejemplo:

* Si el objeto es un `GuiaTuristico`, se ejecuta el método de `GuiaTuristico`.
* Si el objeto es un `Vehiculo`, se ejecuta el método de `Vehiculo`.
* Si el objeto es un `ColaboradorExterno`, se ejecuta el método de `ColaboradorExterno`.

Esto permite utilizar una misma estructura para administrar objetos con comportamientos diferentes.

---

## 🛠️ Tecnologías utilizadas

* Java
* Maven
* IntelliJ IDEA
* Programación Orientada a Objetos
* Interfaces
* Clases abstractas
* Herencia
* Sobrescritura
* Polimorfismo
* Colecciones genéricas
* `ArrayList`
* Operador `instanceof`
* Java Swing
* `JOptionPane`
* Manejo de excepciones
* Validación de datos
* Apache POI
* Lectura de archivos desde `resources`

---

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Clonar el repositorio:

```bash
git clone https://github.com/Marcos17e05/POO-Sumativa2.git
```

2. Abrir el proyecto en IntelliJ IDEA.

3. Esperar a que Maven descargue automáticamente las dependencias necesarias.

4. Verificar que el proyecto utilice una versión compatible de Java.

5. Compilar el proyecto.

6. Ejecutar la clase principal:

```plaintext
src/main/java/com/llanquihuetour/tours/ui/Main.java
```

7. Seleccionar una opción desde el menú principal.

8. Registrar uno o más guías turísticos o vehículos.

9. Seleccionar la opción para mostrar los registros existentes.

10. Seleccionar la opción `Salir` para finalizar el programa.

---

## 📌 Conclusión

La implementación de la interfaz `Registrable` permite establecer un contrato común entre las diferentes entidades gestionadas por Llanquihue Tour.

La clase base `RecursoAgencia` permite reutilizar atributos comunes mediante herencia, mientras que las clases `GuiaTuristico`, `Vehiculo` y `ColaboradorExterno` definen sus propios atributos y sobrescriben el método `mostrarResumen()`.

El uso de `ArrayList<Registrable>` permite almacenar objetos de distintas clases dentro de una sola colección. Gracias al polimorfismo, el sistema puede recorrer todos los objetos mediante una referencia común y ejecutar automáticamente el método correspondiente a cada clase real.

Finalmente el operador `instanceof` permite identificar cada tipo de objeto durante la ejecución y aplicar una lógica diferenciada cuando sea necesario.

---

**Repositorio GitHub:** https://github.com/Marcos17e05/POO-Sumativa3

**Fecha de entrega:** [13/07/2026]

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Desarrollo Orientado a Objetos I

##RobotsApp

### Estructura de datos

La libreria Collections de java implementa varias estructuras de datos  que nos permiten ahorrar tiempo y ganar en claridad. Esta aplicación usará la colección `ArrayList` que implementa la interfaz `List`. La elección de esta clase ha sido por motivos de claridad y no de optimización. La elcción más óptima habría sido tal vez alguna de la implementaciones de la interfaz `Qeue`.

Los métodos que se usarán serán :

- `List.Add(String)` : añadirá un nuevo robot a la lista
- `List.Remove(int)` : borará el elemento contenido en el indice dado.
- `List.size()`       : devolverá el numero de elementos de la lista.

### Estructura y layout

La aplicación contará de 2 actividades, una principal en la que se gestiona la lista y otra en la que se muestra con ayuda de una `ListView`.

La actividad principal lanza la actividad que muestra la lista de robots cuando se pulsa el botón `show`.

![MainActivity](./jerarquia_activities.png  "Actividad Principal")

### Main Activity
Primero se ha empezado por implementar la actividad principal como es lógico.
#### Layout
Lo primero que se ha hecho ha sido el "layout" que se ha realizado con ayuda del editor gráfico para establecer la jerarquía. Esta layout consta de :

- 3 botones : para añadir y borrar elementos de la lista y mostrar la lista.  
- 1 cuadro de entrada de texto para introducir el nombre del robot nuevo.
- 1 imagen.
- 1 Un cuadro de texto para mostrar el numero de robots actuales.


 ![](imgs/20161113-195009.png)
 
Android permite autodimensionar una de las dimensiones de las views mediante pesos (`android:layout_weight`). De esta manera android establece diemsniones relativas proporcionales al peso asignado a cada view.
Para hacer uso de esta funcionalidad hay que poner la dimensión de interés a "0dp" : o bien `android:layout_height="0dp"` o bien `android:layout_weight="10"`. Una cosa que hay que tener en cuenta es que si se usa esta caracteristica en una View no  se podrá poner a `"match_parent"` en las Views del mismo nivel jerárquico.

Para establecer los callback de los botones se ha usado la propiedad `android:onClick`. Las funciones de callback deben ser publicas y seguir el prototipo `public void botonClickedCalback(View v)`.

De esta manera el layout de la actividad principal queda de la siguiente manera.

~~~xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="com.example.abdel.robotsapp.MainActivity">

    <LinearLayout
        android:orientation="vertical"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_alignParentStart="true"
        android:layout_alignParentTop="true">

        <ImageView
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="10"
            app:srcCompat="@drawable/robot_noun_166712_cc"
            android:layout_alignParentBottom="true"
            android:layout_alignParentStart="true"

            android:id="@+id/imageView" />

        <TextView
            android:text="foobar"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="10"
            android:id="@+id/textView_visor"></TextView>


        <LinearLayout
            android:orientation="horizontal"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="5"
            >

            <EditText
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:inputType="textPersonName"
                android:text="RobotName"
                android:ems="10"
                android:id="@+id/editText_robotName"
                android:layout_weight="2" />

            <Button
                android:text="@string/button_add_label"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:id="@+id/buttonAdd"
                android:layout_weight="1"
                android:onClick="addRobot" />
        </LinearLayout>

        <LinearLayout
            android:orientation="horizontal"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="5">

            <Button
                android:text="@string/button_show_label"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:id="@+id/button_show"
                android:layout_weight="1"
                android:onClick="showRobots" />

            <Button
                android:text="@string/button_remove_label"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:id="@+id/button_remove"
                android:layout_weight="1"
                android:onClick="removeRobot" />
        </LinearLayout>
    </LinearLayout>

</RelativeLayout>

~~~
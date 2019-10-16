# DSP Lab Android Demos

This is the repository for Android demos for the [EL-GY 6183 Digital Signal Processing Laboratory](http://bulletin.engineering.nyu.edu/preview_course_nopop.php?catoid=9&coid=24134) taught by [Professor Ivan Selesnick](http://eeweb.poly.edu/iselesni/) at NYU Tandon School of Engineering.

This tutorial intends to demonstrate that Android phones can be used as a tool to develop cool Digital signal processing applications.

## Contents

1. [Java Basics](./Java_Demos/JavaBasics.md)
2. [Kotlin Basics](./Kotlin/README.md)
3. [OpenCV for Android](#opencv)

---

## Android

`Kotlin` has been official language for mobile development on Android since 2017. `Kotlin` is designed to interoperate fully with `Java`. Programs in `Kotlin` are short as opposed to `Java` programs. You may choose to develop apps with `Kotlin` or `Java` depending on your interest.

(To understand this tutorial well, it is recommended to have some prior programming experience in other OOP languages such as C++ or Python or at least have some basic understanding of OOP concepts.)

---

## List of Android app demos available in the repository

To try the series of demos available in the repository, you need to create a new Android project for every demo. Follow these steps to create a new project:

1. To start with, first create an [Empty android project](#creating-a-new-empty-android-project).

2. After creating an empty project, you will see the Android layout has a TextView which says Hello World!

You must be able to see the `Kotlin` or `Java` and `XML` codes in the empty project.

Now you can make changes to the default empty project by writing your own code or using the code of demo apps provided below.

Following are the list of demos available in this repository. Each demo has a readme and well commented code.
(Click on the links of each demo for README)

| Demo Name | Description |||
|-------------|-------------|-------------|-------------|
|`Text Edit Demo`|Simple app with text view and edit text|[Kotlin](./kotlin_implementations/Text_Edit_Demo/README.md)|[Java](./java_implementations/Text_Edit_Demo/README.md)|
|`Fibonacci series app 1`|This app demonstrates how to display fixed length Fibonacci series generated on the app screen and using the Log statements in android |[Kotlin](./kotlin_implementations/Fib_TextView/README.md)|[Java](./java_implementations/Fib_TextView/README.md)|
|`Fibonacci series app 2`|This app demonstrates how to take length of Fibonacci series as user input in app using UI and display the generated Fibonacci series |[Kotlin](./kotlin_implementations/Fib_EditText/README.md)|[Java](./java_implementations/Fib_EditText/README.md)|
|`Text Image Demo`|Simple app with text view and image view|[Kotlin](./kotlin_implementations/Text_Image_demo/README.md)|[Java](./java_implementations/Text_Image_Demo/README.md)|
|`Slider Demo`|App to demonstrate use of slider which is called SeekBar in Android|[Kotlin](./kotlin_implementations/Slider_Demo/README.md)|[Java](./java_implementations/Slider_Demo/README.md)|
|`Sine Wave Demo 1`|App to demonstrate generating sine wave with fixed frequency|[Kotlin](./kotlin_implementations/Sine_Wave_Demo1/README.md)|[Java](./java_implementations/Sine_Wave_Demo1/README.md)|
|`Sine Wave Demo 2`|App to demonstrate generating sine wave with variable frequency (uses buttons)||[Java](./java_implementations/Sine_Wave_Demo2/README.md)|
|`Sine Wave Demo 3`|App to demonstrate generating sine wave with variable frequency (uses SeekBar)||[Java](./java_implementations/Sine_Wave_Demo3/README.md)|
|`Sine Wave Demo 4`|App to demonstrate generating sine wave with variable frequency and gain (uses SeekBar)||[Java](./java_implementations/Sine_Wave_Demo4/README.md)|
|`Accelero-Sine wave`|A fun app. The frequency of the sine wave changes as you move and rotate your phone (uses accelerometer)||[Java](./java_implementations/Accelerometer_Sine_Wave/README.md)|

---

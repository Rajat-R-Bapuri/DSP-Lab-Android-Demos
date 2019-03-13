# Contents

1. [Android Basics](#android-basics)
2. [Getting started with Android Application Development](#getting-started-with-android-application-development)
3. [Building the UI](#building-the-ui)
4. [Android activity life cycle](#android-activity-life-cycle)


# Android Basics
### Role of `Java` and `XML` in Android.
1. `XML` (eXtensible Markup Language): `XML` is used for declaring and defining layouts in android. It can be said that `XML` defines how the UI looks like for the application you are developing. Each element in the `XML` layout has an unique 'id' which can be used to

2. `Java`: `Java` is used to write the logic for the application. This logic can control the actions that take place when user interacts with the application also data is processed using Java code.

---

# Getting started with Android Application Development

1. [Download Android Studio.](https://developer.android.com/studio/index.html)
2. Follow the on-screen instructions to install the Android Studio.

---

### Creating a new Empty Android Project
Open Android Studio, and follow the following images to create an empty project.

1. Welcome Screen of Android Studio.
![Welcome Screen](./images/welcome_to_studio.png)

2. Choose the project from the list of available templates.
![Choose your project](./images/choose_your_project.png)

3. Configure your project by specifying the project name, your workspace location, minimum API level etc.
![Configure your project](./images/configure_your_project.png)

4. Give it a minute or two to build the project. (The build process can be seen on the right bottom part of Android Studio).

5. If the build was successful, you'll see the following screen without any errors:

![Empty Activity](./images/empty_activity.png)

---

# Building the UI
In Android Studio, UI can built using the Layout Editor, `XML` code or both.

## [Layout Editor](https://developer.android.com/studio/write/layout-editor)

Most part for Android UI for basic apps can be done using the drag and drop feature in Android Studio Layout Editor.

Palette (marked in red box) contains all the basic components that can be used to build the UI. Each component can be dragged and dropped to the Design Editor. Each component's attributes can be set and unset using the attributes control marked in green box).
![Layout Editor](./images/layout_editor.png)

---

# Android activity life cycle

Following image shows the various callback methods that can be implemented to perform actions during different states of an activity.

![Activity life cycle](https://developer.android.com/images/activity_lifecycle.png)

**Use Log statements to verify this activity lifecycle**

---

Following are the list of demos available in this repository. Each demo has a readme and well commented code.
(Click on the links of each demo for README)

- [Text Edit Demo](./Demos/Text_Edit_Demo/README.md)
- [Text Image Demo](./Demos/Text_Image_Demo/README.md)
- [Slider Demo](./Demos/Slider_Demo/README.md)
- [Sine Wave Demo 1](./Demos/Sine_Wave_Demo1/README.md)
- [Sine Wave Demo 2](./Demos/Sine_Wave_Demo2/README.md)
- [Sine Wave Demo 3](./Demos/Sine_Wave_Demo3/README.md)
- [Sine Wave Demo 4](./Demos/Sine_Wave_Demo4/README.md)
- [Accelerometer Audio](./Demos/Accelerometer_Sine_Wave/README.md)

---
# OpenCV

[OpenCV setup](./OpenCV/README.md)

// TODO opencv demos

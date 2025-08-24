# Swing-Toast-Notifications

This swing toast notification used for java desktop application gui using swing with flatlaf

<img src="https://github.com/DJ-Raven/swing-toast-notifications/assets/58245926/71965d6a-1fd1-4ab4-b2d7-f7424b9c277e" alt="sample dark" width="450"/>
<img src="https://github.com/DJ-Raven/swing-toast-notifications/assets/58245926/228a958d-ad02-41df-b1aa-b16f7d88deec" alt="sample light" width="450"/>

## Install

This library is not available in maven, try using a jar file, which you can find in the release section.

``` xml
<dependency>
    <groupId>raven.toast</groupId>
    <artifactId>swing-toast-notifications</artifactId>
    <version>1.0.4.1</version>
    <scope>system</scope>
    <systemPath>${basedir}/library/swing-toast-notifications-1.0.4.1.jar</systemPath>
</dependency>
```
- Other libraries which are used with this library
``` xml
<dependency>
  <groupId>com.formdev</groupId>
  <artifactId>flatlaf</artifactId>
  <version>3.4.1</version>
</dependency>

<dependency>
  <groupId>com.formdev</groupId>
  <artifactId>flatlaf-extras</artifactId>
  <version>3.4.1</version>
</dependency>
```
## Getting started

- Import flatlaf library and flatlaf extras to your project
- And Import swing toast notifications

``` java
//  Setup notifications for jframe

Notifications.getInstance().setJFrame(jframe);

// Setup notifications for JDialog

Notifications.getInstance().setJDialog(jdialog);

//  Show notifications

Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Hello");

//  Show notification with custom component

Notifications.getInstance().show(new JButton("My Custom Button"));

//  Clear top right notifications

Notifications.getInstance().clear(Notifications.Location.TOP_RIGHT);

//  Clear all notifications

Notifications.getInstance().clearAll();
```

``` java
//  Install flatlaf look and feel to your application

FlatIntelliJLaf.setup();
```

``` java
//  Notifications Type

public enum Type {
  SUCCESS, INFO, WARNING, ERROR
}

//  Notification Location

public enum Location {
  TOP_LEFT, TOP_CENTER, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT
}

```

## Custom with flatlaf properties

Create flatlaf file properties `FlatLaf.properties`

```
Toast.background=lighten(@background,5%)
Toast.outlineWidth = 1
Toast.success.foreground = rgb(53,198,203)
Toast.frameInsets = 15,15,15,15
```

| Key                        | Description     | Value Type | Default values |
|----------------------------|-----------------|------------|----------------|
| Toast.outlineWidth         |                 | int        | 0              |
| Toast.iconTextGap          |                 | int        | 5              |
| Toast.closeButtonGap       |                 | int        | 5              |
| Toast.arc                  |                 | int        | 20             |
| Toast.horizontalGap        |                 | int        | 10             |
| Toast.limit                | -1 as unlimited | int        | -1             |
| Toast.duration             |                 | long       | 2500           |
| Toast.animation            |                 | int        | 200            |
| Toast.animationResolution  |                 | int        | 5              |
| Toast.animationMove        |                 | int        | 10             |
| Toast.minimumWidth         |                 | int        | 50             |
| Toast.maximumWidth         | -1 as not set   | int        | -1             |
| Toast.shadowColor          |                 | Color      |                |
| Toast.shadowOpacity        | 0 to 1f         | float      | 0.1f           |
| Toast.shadowInsets         |                 | Insets     | 0,0,6,6        |
| Toast.useEffect            |                 | boolean    | true           |
| Toast.effectWidth          | 0.5f as 50%     | float      | 0.5f           |
| Toast.effectOpacity        | 0 to 1f         | float      | 0.2f           |
| Toast.effectAlignment      | left, right     | String     | left           |
| Toast.effectColor          |                 | Color      |                |
| Toast.success.effectColor  |                 | Color      |                |
| Toast.info.effectColor     |                 | Color      |                |
| Toast.warning.effectColor  |                 | Color      |                |
| Toast.error.effectColor    |                 | Color      |                |
| Toast.outlineColor         |                 | Color      |                |
| Toast.foreground           |                 | Color      |                |
| Toast.background           |                 | Color      |                |
| Toast.success.outlineColor |                 | Color      |                |
| Toast.success.foreground   |                 | Color      |                |
| Toast.success.background   |                 | Color      |                |
| Toast.info.outlineColor    |                 | Color      |                |
| Toast.info.foreground      |                 | Color      |                |
| Toast.info.background      |                 | Color      |                |
| Toast.warning.outlineColor |                 | Color      |                |
| Toast.warning.foreground   |                 | Color      |                |
| Toast.warning.background   |                 | Color      |                |
| Toast.error.outlineColor   |                 | Color      |                |
| Toast.error.foreground     |                 | Color      |                |
| Toast.error.background     |                 | Color      |                |
| Toast.frameInsets          |                 | Insets     | 10,10,10,10    |
| Toast.margin               |                 | Insets     | 8,8,8,8        |
| Toast.showCloseButton      |                 | boolean    | true           |
| Toast.closeIconColor       |                 | Color      |                |

## Using UI Manager

``` java
//  Using flatlaf extras to create flat svg icon
//  Use this code in main method

UIManager.put(ToastClientProperties.TOAST_INFO_ICON, new FlatSVGIcon("raven/toast/error.svg"));
```

| Key                | Description | Value Type |
|--------------------|-------------|------------|
| Toast.success.icon |             | Icon       |
| Toast.info.icon    |             | Icon       |
| Toast.warning.icon |             | Icon       |
| Toast.error.icon   |             | Icon       |
| Toast.closeIcon    |             | Icon       |

Visit flatlaf for more

- [Flatlaf github](https://github.com/JFormDesigner/FlatLaf)
- [Flatlaf documentation](https://www.formdev.com/flatlaf/customizing/)

### Update Note
- `version 1.0.1`
  - add properties `Toast.maximumWidth`
  - add properties `Toast.limit`
  - add method `void clearHold()` and `void clearHold(Location location)`
- `version 1.0.4.1`
  - added support for JDialog 
### Fixed Note
- `version 1.0.1`
  - fixed notification style properties background

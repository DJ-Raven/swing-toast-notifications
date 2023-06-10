# Swing-Toast-Notifications

This swing toast notifications use for java desktop application gui swing with flatlaf


## Getting started
- Import flatlaf library and flatlaf extras to your project
- And Import swing toast notifications `(check jar file in libary folder)`

``` java
//  Setup notifications with jfram

Notifications.getInstance().setJFrame(jfram);

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
  SUCCESS, INFO, WARNING, ERROR,
}

//  Notification Location

public enum Location {
  TOP_LEFT, TOP_CENTER, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT
}

```
## Custom with flatlaf properties
Create flatlaf file properties `FlatLaf.properties`
```
Toast.outlineWidth = 1
Toast.success.foreground = rgb(53,198,203)
Toast.frameInsets = 15,15,15,15
```

| Key           | Description   | Value Type    | Default values|
| ------------- | ------------- | ------------- | ------------- |
| Toast.outlineWidth  | --  | int  | 0  |
| Toast.iconTextGap  | --  | int  | |
| Toast.arc  | --  | int | 10 |
| Toast.horizontalGap  | --  | int  | 10 |
| Toast.animation  | --  | int | 200 |
| Toast.animationMove  | --  | int  | 10 |
| Toast.animationResolution  | --  | int  | 5 |
| Toast.shadowWidth  | --  | int  | 4 |
| Toast.minWidth  | --  | int  | 30 |
| Toast.shadowX  | --  | int  | 1 |
| Toast.shadowY  | --  | int  | 1 |
| Toast.duration  | --  | long  | 2500 |
| Toast.shadowOpacity  | --  | float  | 0.1f |
| Toast.success.outlineColor  | --  | Color  | |
| Toast.success.foreground  | --  | Color  | |
| Toast.success.background  | --  | Color  | |
| Toast.warning.outlineColor  | --  | Color  | |
| Toast.warning.foreground  | --  | Color  | |
| Toast.warning.background  | --  | Color  | |
| Toast.error.outlineColor  | --  | Color  |  |
| Toast.error.foreground  | --  | Color  | |
| Toast.error.background  | --  | Color  | |
| Toast.shadowColor  | --  | Color  | |
| Toast.frameInsets  | --  | Insets  | 10,10,10,10 |
| Toast.insets  | --  | Insets  | 8,8,8,8 |

## Using UI Manager

``` java
//  Using flatlaf extras to crate flat svg icon
//  Use this code in main method

UIManager.put("Toast.error.icon", new FlatSVGIcon("raven/toast/error.svg"));
```

| Key           | Description   | Value Type    |
| ------------- | ------------- | ------------- |
| Toast.success.icon  | --  | Icon |
| Toast.warning.icon  | --  | Icon |
| Toast.error.icon  | --  | Icon |

Visit flatlaf for more
- [Flatlaf github](https://github.com/JFormDesigner/FlatLaf)
- [Flatlaf doc](https://www.formdev.com/flatlaf/customizing/)

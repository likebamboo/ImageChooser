ImageChooser
============
## 关于

android本地图片展示、选择程序。界面参考微信。   
在加载本地图片的速度上可媲美微信的图片选择，同时不会造成界面卡顿现象。   
关于本程序的更多介绍，请移步[这里](http://likebamboo.github.io/)。

## 安装

apk文件夹下附带安装包(未签名)。

## 编译与运行

本项目开发工具为Eclipse，你可以将ImageChooser文件夹下的项目导入到eclipse中编译并运行。   如果你使用ant来编译构建项目，你需要在ImageChooser文件夹下建立一个local.properties文件，该文件的内容为

    sdk.dir=【AndroidSDK所在的目录】   

之后，你可以在命令行中定位到ImageChooser文件夹，执行ant debug命令来编译该项目。

## 预览

![ImageChooser](https://raw.github.com/likebamboo/ImageChooser/master/screenCapture/device-2014-04-28-140839.png)
![ImageChooser](https://raw.github.com/likebamboo/ImageChooser/master/screenCapture/device-2014-04-28-140920.png)
![ImageChooser](https://raw.github.com/likebamboo/ImageChooser/master/screenCapture/device-2014-04-28-140943.png)

## 用到的第三方库
* [UniversalImageLoader](https://github.com/nostra13/Android-Universal-Image-Loader) 目前最流行的图片异步加载库，配置强大，使用简单，绝对能满足你的各种需求！

* [PhotoView](https://github.com/chrisbanes/PhotoView) 图片手势缩放库，很好用，也一直在用！

## Pull Requests
I will gladly accept pull requests for fixes and feature enhancements but please do them in the develop branch


## 关于我

[请移步这里](http://likebamboo.github.io/about.html)

License
============

    Copyright 2014 likebamboo

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.

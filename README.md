## 关于

android本地图片展示、选择程序。界面参考微信。   
在加载本地图片的速度上可媲美微信的图片选择，不会造成界面卡顿现象。   
想了解本程序开发过程中的一些想法与历程，请移步[这里](http://likebamboo.github.io/android/2014/04/28/image_chooser/)。  
本程序纯粹是根据个人的一些想法做的，可能并不是最好的解决方案，如果您有更好的解决方案，希望您能分享出来，或通过issues交流。

## 安装

apk文件夹下附带安装包(未签名)。

## 编译与运行

本项目开发工具为Eclipse，同时使用maven作为构建工具，项目主目录在ImageChooser文件夹下。  
如果你的 Eclipse 中装有 Maven 插件，请将本项目作为 Maven 项目导入到Eclipse中，之后可以使用Maven build 构建项目了。  
如果你的 Eclipse 中没有 Maven 插件，将项目作为Android项目导入到Eclipse中后会报错，这时你需要在项目中创建一个libs的目录，然后将android-support-v4.jar 支持包，
以及下文中提到的 [universal-image-loader-1.9.3.jar](https://github.com/nostra13/Android-Universal-Image-Loader)
和 [photoview.jar](http://central.maven.org/maven2/com/github/chrisbanes/photoview/library/1.2.2/library-1.2.2.jar)下载拷贝到libs目录，并将这些jar加入到Build Path中，之后就可以用eclipse来编译运行项目了。  
如果你使用ant来编译构建项目，你需要在ImageChooser文件夹下建立一个local.properties文件，该文件的内容为

    sdk.dir=【Android SDK所在的目录】   

之后，你可以在命令行中定位到ImageChooser文件夹，执行ant debug命令来编译该项目。

## 预览

![ImageChooser](https://raw.github.com/likebamboo/ImageChooser/master/screenCapture/device-2014-04-28-140839.png)
![ImageChooser](https://raw.github.com/likebamboo/ImageChooser/master/screenCapture/device-2014-04-28-140920.png)
![ImageChooser](https://raw.github.com/likebamboo/ImageChooser/master/screenCapture/device-2014-04-28-140943.png)

## 用到的第三方库
* [UniversalImageLoader](https://github.com/nostra13/Android-Universal-Image-Loader) 目前最流行的图片异步加载库，配置强大，使用简单，绝对能满足你的各种需求！【本程序中查看大图的时候用到】

* [PhotoView](https://github.com/chrisbanes/PhotoView) 图片手势缩放库，很好用，也一直在用！【本程序中查看大图的时候用到】

## Pull Requests
I will gladly accept pull requests for fixes and feature enhancements but please do them in the develop branch


## 关于我

[I am  here](http://likebamboo.github.io/about.html)

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

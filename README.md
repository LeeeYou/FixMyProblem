# FixMyProblem
@(示例笔记本)[马克飞象|帮助|Markdown]

-------------------

[TOC]

### 1、ImageView的background和src的不同
如果两个属性同时存在,用户会看到 src 属性中设置的背景. 但同时 background 设置的背景也存在, 只是被 src 属性挡住了,在后面. src 等于是前景, background 等于是背景.background 会根据 ImageView 组件给定的长宽进行拉伸, 而 src 就存放的是原图的大小, 不会进行拉伸。src 是图片内容（前景）, bg 是背景, 可以同时使用.此外: scaleType 只对 src 起作用,比如在 ImageView 中就可以用 android:scaleType 控制图片的缩放方式 ; bg 可设置透明度.
![](/images/01_img_src.png)
![](/images/01_img_background.png)

### 2、Glide加载圆形图和圆角图
### 3、setCompoundDrawablesWithIntrinsicBounds的优势
### 4、滑动事件冲突的处理
### 5、shape资源整理
### 6、记录bug:Manifest merger failed error
### 7、整理ripple
### 8、整理fragment universalAdapter notify不成功的原因
### 9、记录bug：recyclerView在fragment中 notifyDataSetChange不起作用的问题
### 10、EventBus粘性事件
### 11、事件传递机制
### 12、9patch
### 13、Fragment的使用总结
### 14、Math中对于小数的处理
### 15、开发经验整理
### 16、ExpandableListView
### 17、JSONArray ，JSONObject , json相互转换

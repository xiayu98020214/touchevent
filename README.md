编译的时候，请修改gradle.properties

android.enableBuildCache=true

android.buildCacheDir =r:\\Temp\\

把"r:\\Temp\\"请修改自己的路径，比如d:\\temp\\

这个例子是用了继承的方法实现了自定义view。

ViewB的onTouchEvent return设置成true。

<code>
06-03 22:27:36.254 13862-13862/com.xiayu.touchevent I/MainActivity: MainActivity-dispatchTouchEvent-ACTION_DOWN...0
06-03 22:27:36.255 13862-13862/com.xiayu.touchevent I/ViewA: dispatchTouchEvent-ACTION_DOWN...0
06-03 22:27:36.255 13862-13862/com.xiayu.touchevent I/ViewA: onInterceptTouchEvent-ACTION_DOWN...0
06-03 22:27:36.255 13862-13862/com.xiayu.touchevent I/ViewB: dispatchTouchEvent-ACTION_DOWN...0
06-03 22:27:36.255 13862-13862/com.xiayu.touchevent I/ViewB: onTouchEvent-ACTION_DOWN...0
06-03 22:27:36.322 13862-13862/com.xiayu.touchevent I/MainActivity: MainActivity-dispatchTouchEvent-ACTION_UP...1
06-03 22:27:36.322 13862-13862/com.xiayu.touchevent I/ViewA: dispatchTouchEvent-ACTION_UP...1
06-03 22:27:36.322 13862-13862/com.xiayu.touchevent I/ViewA: onInterceptTouchEvent-ACTION_UP...1
06-03 22:27:36.322 13862-13862/com.xiayu.touchevent I/ViewB: dispatchTouchEvent-ACTION_UP...1
06-03 22:27:36.323 13862-13862/com.xiayu.touchevent I/ViewB: onTouchEvent-ACTION_UP...1

ViewA的onTouchEvent设置成super.onTouchEvent(event);
06-03 22:29:42.423 15073-15073/com.xiayu.touchevent I/MainActivity: MainActivity-dispatchTouchEvent-ACTION_DOWN...0
06-03 22:29:42.424 15073-15073/com.xiayu.touchevent I/ViewA: dispatchTouchEvent-ACTION_DOWN...0
06-03 22:29:42.424 15073-15073/com.xiayu.touchevent I/ViewA: onInterceptTouchEvent-ACTION_DOWN...0
06-03 22:29:42.424 15073-15073/com.xiayu.touchevent I/ViewB: dispatchTouchEvent-ACTION_DOWN...0
06-03 22:29:42.424 15073-15073/com.xiayu.touchevent I/ViewB: onTouchEvent-ACTION_DOWN...0
06-03 22:29:42.424 15073-15073/com.xiayu.touchevent I/ViewA: onTouchEvent-ACTION_DOWN...0
06-03 22:29:42.424 15073-15073/com.xiayu.touchevent I/MainActivity: MainActivity-onTouchEvent-ACTION_DOWN...0
06-03 22:29:42.546 15073-15073/com.xiayu.touchevent I/MainActivity: MainActivity-dispatchTouchEvent-ACTION_UP...1
06-03 22:29:42.546 15073-15073/com.xiayu.touchevent I/MainActivity: MainActivity-onTouchEvent-ACTION_UP...1


ViewB的onInterceptTouchEvent设置成return true;
06-03 22:41:02.293 22003-22003/com.xiayu.touchevent I/MainActivity: MainActivity-dispatchTouchEvent-ACTION_DOWN...0
06-03 22:41:02.293 22003-22003/com.xiayu.touchevent I/ViewA: dispatchTouchEvent-ACTION_DOWN...0
06-03 22:41:02.294 22003-22003/com.xiayu.touchevent I/ViewA: onInterceptTouchEvent-ACTION_DOWN...0
06-03 22:41:02.294 22003-22003/com.xiayu.touchevent I/ViewA: onTouchEvent-ACTION_DOWN...0
06-03 22:41:02.294 22003-22003/com.xiayu.touchevent I/MainActivity: MainActivity-onTouchEvent-ACTION_DOWN...0
06-03 22:41:02.359 22003-22003/com.xiayu.touchevent I/MainActivity: MainActivity-dispatchTouchEvent-ACTION_UP...1
06-03 22:41:02.360 22003-22003/com.xiayu.touchevent I/MainActivity: MainActivity-onTouchEvent-ACTION_UP...1
</code>
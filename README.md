# AndroidObjectStore aka ASFObjectStore
A Simple Object Store to push/pop objects accessible by unique keys, Extremely Helpful for passing Custom Objects in between Activities/Services and other components.

Inspired from [Android Docs](http://developer.android.com/guide/faq/framework.html#3).

<h2>Why AndroidObjectStore</h2>
In addition to acting as a general Object Store this library is great for passing custom objects in between activities, services, Fragments and other components. Here's Why:

Currently for passing custom objects in between activities either we have to implement Parcellable or Serialization which not only justs adds un-necessary work to add extra code and moreover adds both performance and memory hit, which is defintely not a good way to go!

Some developers use third party libraries like greendao's EventBus, i am great fan of EventBus too but using it in this scenario is not correct for two reasons:
1- It keeps a strong reference to the object which can lead to various memory leaks
2- It exposes the Object to be picked up by any other class, resulting in a Mess.

If you just want to pass custom objects within same process than ASFObjectStore is quite flexible and handy.

<h2>USAGE</h2>
**Note:** You can either create a new instance of ASFObectStore (For dependency Injection/Any other reason) or just use the global instance by using getDefault() method.

Suppose we have a custom object named 'myObject' which is a field of 'ABCActivity' and we want to pass it to 'XYZActivity':

**In ABCActivity**
```
// We can push a weak reference safely here because myOject is being retained by sender activity
// We could also call the method pushStrong() to make the object retained at all costs until it 
// gets popped!
String myObjectKey = ASFObjectStore.getDefault().pushWeak(myObject);
intent.putExtra(XYZActivity.EXTRA_MY_OBJECT_KEY, myObjectKey);
```

**In XYZActivity**
```
String myObjectKey = getIntent().getStringExtra(EXTRA_MY_OBJECT_KEY);
// Single method pop(), for both pushWeak() and pushStrong()
myObject = ASFObjectStore.getDefault().pop(myObjectKey);
```

If you are creating a new instance of ASFObjectStore and want to pass in objects of a specific type, then you can benefit from templating like this:
```
ASFObjectStore<String> myStringsStore = new ASFObjectStore();
```

<h2>Installation</h2>
Lightweight and easy to use, just a single file (ASFObjectStore.java) of size 3KB

**Eclipse**
- Download and include ASFObjectStore.java

**Gradle**
- Use above method for now, In process of uploading it to Maven Central


<h2>Author</h2>
Asif Mujteba, asifmujteba@gmail.com
Twitter: @asifmujteba

<h2>License</h2>
This library is available under the MIT license. See the LICENSE file for more info.

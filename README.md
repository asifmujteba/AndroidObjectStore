# ASFObjectStore
A Simple Object Store to push/pop objects accessible by unique keys, Extremely Helpful for passing Custom Objects between Activities and other components.

<h2>USAGE</h2>
Suppose we have a custom object named 'myObject' which we want to pass from 'ABCActivity' to 'XYZActivity':

**In ABCActivity**
```
String myObjectKey = ASFObjectStore.shared().push(myObject);
intent.putExtra(XYZActivity.MY_OBJECT_KEY, myObjectKey);
```

**In XYZActivity**
```
String myObjectKey = getIntent().getStringExtra(MY_OBJECT_KEY);
myObject = ASFObjectStore.shared().pop(myObjectKey);
```

<h2>Add EventBus to your project</h2>
TODO

<h2>Author</h2>
Asif Mujteba, asifmujteba@gmail.com

<h2>License</h2>
ASFObjectStore is available under the MIT license. See the LICENSE file for more info.

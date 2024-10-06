
# react-native-device-lock-task
Pin/lock your app to device screen. 🐎 New Architecture support


## Installation

### Adding the package

#### npm

```bash
$ npm install react-native-device-lock-task
```

#### yarn

```bash
$ yarn add react-native-device-lock-task
```



### Example

```typescript
import RTNLockTask from 'react-native-device-lock-task/js/NativeDeviceLockTask'

const lockTask=async()=>{
    await RTNLockTask?.startLockTask()
}

const stopLockTask=async()=>{
    await RTNLockTask?.stopLockTask()
}

const checkLockTaskStatus=async()=>{
    await RTNLockTask?.isAppInLockTaskMode()
}

```



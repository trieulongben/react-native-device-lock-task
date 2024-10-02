import type {TurboModule} from 'react-native/Libraries/TurboModule/RCTExport';
import {TurboModuleRegistry} from 'react-native';


enum IDestination{
    BOTH='both',
    SYSTEM='system',
    LOCK='lock'
}

type TDestination='both'|'system'|'lock'

export interface Spec extends TurboModule {
  isAppInLockTaskMode():Promise<boolean>;
  startLockTask():Promise<any>;
  stopLockTask():Promise<any>;
}

export default TurboModuleRegistry.get<Spec>('RTNDeviceLockTask') as Spec | null;
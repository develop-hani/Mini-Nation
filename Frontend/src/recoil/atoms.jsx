import { atom } from 'recoil';
import { recoilPersist } from 'recoil-persist';

const { persistAtom } = recoilPersist();
export const identityState = atom({
    key: 'identityState',
    default: '',
    effects_UNSTABLE: [persistAtom],
});
export const companyState = atom({
    key: 'somethingState',
    default: '',
    effects_UNSTABLE: [persistAtom],
});

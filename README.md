# HashMap_Sync_Test
HashMap_Sync_Test

#### Map 의 element 에 Sync 를 걸었을 때 다른 쓰레드에서 해당 Sync 에 접근할 수 있는가?
##### 접근할 수 없고, 해당 element 에 먼저 Sync 걸고 작업 중인 쓰레드가 작업이 끝나면 다른 대기 중인 하나의 쓰레드가 다시 접근 가능하다.

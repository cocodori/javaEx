# ? 상수시간constant time
> 실행 시간이 입력 크기에 의존하지 않으면 알고리즘은 상수 시간constant time을 따른다고 한다. 이를테면, n개의 배열에서 브래킷 연산([])을 사용하여 요소 중 하나에 접근할 때 이 연산은 배열의 크기와 관계 없이 같은 수의 동작을 한다.

# ? 선형linear
> 실행 시간이 입력 크기에 비례하면 알고리즘은 선형linear이라고 한다. 배열에 있는 요소를 더한다면 n개 요소에 접근하여 n-1번 더하기 연산을 해야 한다. 연산 요소(요소 접근과 더하기)의 총 횟수는 2n-1이고 n에 비례한다.

# ? 이차quadratic
 실행시간이 n^2에 빌례하면 알고리즘은 이차quadratic라고 한다. 말하자면 리스트에 있는 어떤 요소가 두 번 이상 나타나는지를 알고 싶다고 하자. 간단한 알고리즘은 각 요소를ㄹ 다른 모든 요소와 비교하는 것이다. n개의 요소가 있고 각각 n-1개의 다른 요소와 비교하면 총 비교 횟수는 n^2-n이 되어 n이 커지면서 n^2에 비례하게 된다.
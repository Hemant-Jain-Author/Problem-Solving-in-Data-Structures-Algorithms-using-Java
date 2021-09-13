public class system {
    private map<int, int> personIdToMachineIdMap;
    private map<int, Machine> machineIdToMachineMap;

    Machine getMachine(int machineId);

    Person getPerson(int personId) {
        int machineId = personIdToMachineIdMap[personId];
        Machine m = machineIdToMachineMap[machineId];
        return m.getPersonWithId(personId);
    }
}

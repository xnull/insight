
!!!! надо перепилить на стэйты, вмето обращения к дому. И показать разные варианты работы с формами: акксессор, сторы с ончейнджами


/**
 * Позволяет получать данные из источника. Источник передает функцию доступа к его данным.
 * Приемник данных когда ему понадобится получит данные через метод get который в свою очередь вызовет метод получения данных
 * из источника.
 * В частности позволяет получить доступ к значению какого-либо компонента ввода, например input, если он представлен как react компонент.
 */
class ValueExtractor {
    constructor() {
        this.accessor = null;
    }

    setAccessor(accessor) {
        this.accessor = accessor
    }

    get() {
        if (this.accessor === null) {
            throw new Error("Accessor doesn't set")
        }
        return this.accessor()
    }
}

class FilterStatement extends React.Component {
    /**
     * filter: {fieldName: "cameraId", operations: ["eq","bw","cn","nc"]}
     * @param params
     */
    constructor(params) {
        super(params);
        this.operationValue = new ValueExtractor();
    }

    getFilterRule() {
        return this.operationValue.get();
    }

    render() {
        return (
            <div className="row">
                <div className="col-md-3">
                    <label>test label</label>
                </div>

                <FilterOps {...this.props} valueExtractor={this.operationValue}/>

                <div className="col-md-1"></div>

                <div className="col-md-5">
                    <input ref="filterValue" className="form-control"/>
                </div>
            </div>
        )
    }
}


class FilterOps extends React.Component {
    constructor(props) {
        super(props);
        this.props.valueExtractor.setAccessor(() => this.getOp())
    }

    getOp() {
        return ReactDOM.findDOMNode(this.refs.filterOpSelect).value;
    }

    render() {
        return (
            <div className="col-md-3">
                <select ref="filterOpSelect" className="form-control">
                    <option value={this.props.value}>test</option>
                </select>
            </div>
        )
    }
}


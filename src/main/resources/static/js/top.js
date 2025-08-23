import { gridjsLanguageConfig, gridjsStyleConfig } from "./myGridjsConfig.js";
const tableOfServerSide = new gridjs.Grid({
    columns: [
        {
            id: "title",
            name: "案件名",
        },
        {
            id: "customer",
            name: "顧客名",
        },
        {
            id: "action",
            name: "",
            sort: false,
            formatter: (cell) => {
                // 複数のパラメータを渡す場合は、値のセット方法を別途考えないといけない。
                // タグに値をあらかじめ設定しておくのではなく、
                // buttonタグに「data-~」の形式で値を持っておき、
                // イベントリスナーを使って動的にformを作る方針にする。
                // 今回は値が一つで一意になるので簡単にしました。
                const buttonHtml = `<button button="button" form="detail-page-move-form" name="targetOrderId" value="${cell}" class="send" data-order-id="${cell}">詳細</button>`;
                return gridjs.html(buttonHtml);

            }
        }
    ],
    sort: true,
    style: gridjsStyleConfig,
    language: gridjsLanguageConfig,
    server: {
        url: tableData,
        method: "GET",
        body: null,
        then: data => data.data.map(card => [card.title, card.customer, card.orderId]),
        handle: (res) => {
            // no matching records found
            if (res.status === 404) return { data: [] };
            if (res.ok) return res.json();

            throw Error("oh no :(");
        },
        total: (data) => data.total
    },
    sort: {
        multiColumn: false,
        server: {
            url: () => tableData,
            body: (prev, columns) => {
                console.log(`sort-prev:${prev}`);
                console.log(`sort-columns:${columns}`);
                return null;
            }
        }
    },
    pagination: {
        limit: 5,
        server: {
            url: () => tableData,
            body: (prev, page, limit) => {
                console.log(`pagination-prev:${prev}`);
                console.log(`pagination-page:${page}`);
                console.log(`pagination-limit:${limit}`);
                return null;
            }
        }
    }
}).render(document.getElementById("gridjs-table"));

const table = document.getElementById("gridjs-table");
table.addEventListener("click", event => {

});